package p03Array;

import java.util.Arrays;

public class Ex01ArrayDeclare {
  public static void main(String[] args) {
    // 배열의 원소는 타입의 기본값을 따른다.
    int[] score = new int[12];
    System.out.println(score.length);
    System.out.println(score);
    for (int i = 0; i < score.length; i++) {
      System.out.print(score[i]);
    }

    // 참조형 배열은 기본값이 null
    Object score2[];
    score2 = new Object[12];
    for (int i = 0; i < score2.length; i++) {
      System.out.println(score2[i]);
    }

    // 1) 배열 선언
    String[] arr = new String[6];
    arr[0] = "강지원";arr[1] = "남승일";arr[2] = "김진형";
    System.out.println(arr.length);
    System.out.println(Arrays.toString(arr));

    // 2) 배열 선언
    String[] arr2 = {"강지원", "남승일", "김진형",
        "정서진", "남민호", "정성호"};
    System.out.print("[");
    for (int i = 0; i < arr2.length; i++) {
      if(i!=0) System.out.print(",");
      System.out.print(arr2[i]);
    }
    System.out.println("]");

    // 3) 배열 선언
    String arr3[] = new String[]{};
    System.out.println(arr3.length);
    String str = "";  //char str[] = new char[]{}
    System.out.println(str.length());
  }
}
