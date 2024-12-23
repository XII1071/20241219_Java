package p02method;

import common.Util;

import java.util.Scanner;

public class Ex06Condition {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("점수 입력 : ");
    var input = scan.nextInt();
    Util.typeof(input);
    String result = "";

    if (input >= 90) {
      result = "A";
    } else if (input >= 80) {
      result = "B";
    } else if (input >= 70) {
      result = "C";
    } else if (input >= 60) {
      result = "D";
    } else {
      result = "F";
    }
    // 학점 결과 출력
    System.out.println(String.format("당신의 학점은 %s", result));

    // 태어난 월 입력
    System.out.print("태어난 월을 입력하세요: ");
    int month = scan.nextInt();  // 사용자로부터 태어난 월을 입력받음
    String season = "";          // 계절을 저장할 변수
    switch (month) {
      case 3:  // 3월, 4월, 5월은 봄
      case 4:
      case 5:
        season = "봄";
        break;

      case 6: // 6월, 7월, 8월은 여름
      case 7:
      case 8:
        season = "여름";
        break;

      case 9: // 9월, 10월, 11월은 가을
      case 10:
      case 11:
        season = "가을";
        break;

      case 12: // 12월, 1월, 2월은 겨울
      case 1:
      case 2:
        season = "겨울";
        break;

      default: // 1~12월 이외의 값은 잘못된 입력
        season = "잘못된 입력입니다";
    }

    System.out.println("당신이 태어난 계절은 " + season + "이군요"); // 계절 결과 출력
    scan.close(); // Scanner 객체 닫기 (리소스 누수를 방지)
  }
}
