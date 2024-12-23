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
    System.out.println(String.format("당신의 학점은 %s", result));


  }
}
