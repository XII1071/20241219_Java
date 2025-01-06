package p02method;

import common.Util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex07Loop {
  public static void main(String[] args) {
    /*
    for (int i = 10; i > 0; i--) {
      System.out.println(i);
      try {
        Thread.sleep(100);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    System.out.println("즐거운 맘의 숫자(1~100) 맞추기 게임");
    int randNum = (int) (Math.random() * 100) + 1;
//    int randNum = (int) Math.random() * 100; //random 안됨
//    int randNum = Util.rand(100) + 1;
    int cnt = 0;
    while (true) {
      String input = JOptionPane.showInputDialog("번호를 입력하세요", null);
      cnt++;
      if (randNum == Integer.parseInt(input)) {
        System.out.println(cnt + "번만에 맞췄습니다.");
        break;
      } else if (randNum > Integer.parseInt(input)) {
        System.out.println("작습니다.");
      } else if (randNum < Integer.parseInt(input)) {
        System.out.println("큽니다.");
      }
    }

    Scanner scan = new Scanner(System.in);
    System.out.println("[회원관리 1.0Version]");
    do {
      System.out.println("메뉴를 선택하세요");
      System.out.println("1) 회원등록");
      System.out.println("2) 회원검색");
      System.out.println("3) 종료");
      String input = scan.next();
      if (input.equals("1")) {
        System.out.println("회원등록을 선택하셨습니다.");
      } else if (input.equals("2")) {
        System.out.println("회원검색을 선택하셨습니다.");
      } else if (input.equals("3")) {
        System.out.println("종료를 선택하셨습니다.");
        break;
      }
    } while (true);

    while (true) {
      int you = (int) (Math.random() * 3);
      System.out.println("당신의 패를 입력(0:가위,1:바위,2:보");
      String me = scan.next();
      if(Integer.parseInt(me)<0 && Integer.parseInt(me)>2) break;

      int result = you - Integer.parseInt(me);
      switch (result) {
        case 0:
          System.out.println("비겼다");break;
        case -1: case 2:
          System.out.println("졌다");break;
        default:
          System.out.println("이겼다");break;
      }
    }
    System.out.println("게임을 종료합니다.");
    */

    //무한 반복
    int[] lotto = new int[6];
    int idx = 0;
    for (; ; ) {
      int ball = (int) (Math.random() * 45) + 1;

      // 중복 체크 구문
      boolean check = false;
      for (int i = 0; i < lotto.length; i++) {
        if (ball == lotto[i]) {
          check = true;
          break;
        }
      }

      //중복이 없을 경우 추가하는 구문
      if (!check) {
        lotto[idx] = ball;
        idx++;
        if (idx == 6) break;
      }
    }
    System.out.println(Arrays.toString(lotto));
  }
}