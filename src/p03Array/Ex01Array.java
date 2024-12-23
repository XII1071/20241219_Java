package p03Array;

import common.Util;

import java.util.Arrays;

public class Ex01Array {
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

    int[] arr = new int[10];
    for (int i = 0; i < arr.length; i++) {
//      arr[i] = i + 1;
      arr[i] = (int) (Math.random() * 10) + 1;
//      arr[i] = Util.rand(10) + 1;
      if (i != 0)  // 마지막 요소가 아니면 쉼표 출력
        System.out.print(", ");
      System.out.print(arr[i]);
    }
    System.out.println();
    System.out.println(Arrays.toString(arr));

    // 합계 & 평균
    int[] arr2 = new int[10];
    int tot = 0;
    for (int i = 0; i < arr2.length; i++) {
      arr[i] = i + 1;
//      arr[i] = Util.rand(10) + 1;
      if (i != 0)  // 마지막 요소가 아니면 쉼표 출력
        System.out.print(", ");
      System.out.print(arr[i]);
      tot += arr[i];
    }
    System.out.println();
    System.out.println(Arrays.toString(arr));
    System.out.println(String.format("total: %d, average: %4.2f", tot,
        (float) tot / arr.length));
    
    //셔플
    for (int i = 0; i < arr.length; i++) {
      int r = (int) (Math.random() * 10);
      int tmp = arr[i];
      arr[i] = arr[r];
      arr[r] = tmp;
    }
    System.out.println(Arrays.toString(arr));
  }
}

