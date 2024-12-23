package p02method;

import common.Util;

import java.util.Scanner;

public class Ex06Condition {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("점수 입력:");
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
    System.out.println(String.format("당신의 학점은 %s", result));

    System.out.print("당신이 태어난 월을 입력:");
    String month = scan.next();
    String season = "";
    switch (month) {
      case "3":
      case "4":
      case "5":
        season = "봄";
        break;
      case "6":
      case "7":
      case "8":
        season = "여름";
        break;
      case "9":
      case "10":
      case "11":
        season = "가을";
        break;
      default:
        season = "겨울";
    }
    System.out.println(season + "입니다");
  }
}