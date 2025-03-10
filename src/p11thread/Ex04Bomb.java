package p11thread;

import javax.swing.*;

public class Ex04Bomb {
  public static void main(String[] args) {
    Bomb bomb = new Bomb();
    bomb.start();
    String input = JOptionPane.showInputDialog(
        "빨간선(0), 파란선(1) 중에 선택하시오.");
    bomb.choice(input);
  }
}

class Bomb extends Thread {
  private int lifeLine = (int) (Math.random() * 2);
  private boolean state;

  @Override
  public void run() {
    for (int i = 10; i > 0 ; i--) {
      if (state) break;
      System.out.println(i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    // 카운트 다운이 0으로 끝났을 때 강제 종료
    if(!state) System.out.println("Bomb~!");
    System.exit(-1);
  }
  void choice(String input) {
    state = true;
    if (lifeLine == Integer.parseInt(input)) {
      System.out.println("휴~ 살았다.");
    } else {
      System.out.println("꽝~!");
    }
  }
}