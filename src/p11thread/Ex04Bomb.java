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

  private boolean stopCountdown = false;

  @Override
  public void run() {
    for (int i = 10; i > 0; i--) {
      if (stopCountdown) {
        break;
      }
      System.out.println(i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("00:00");
    System.exit(-1);
  }

  void choice(String input) {
    if (lifeLine == Integer.parseInt(input)) {
      stopCountdown = true;
      System.out.println("휴~ 살았다.");
    } else {
      System.out.println("이세카이 엔딩 에반데");
      System.exit(-1);
    }
  }
}