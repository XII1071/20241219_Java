package p06JavaPackage;

import java.util.Arrays;

import static java.lang.Math.*;

public class Ex02Math {
  public static void main(String[] args) {
    System.out.println(Math.abs(-10));
    System.out.println(Math.ceil(10.1)); //절상
    System.out.println(floor(10.9)); //절삭
    System.out.println(Math.round(0.5));
    System.out.println(Math.round(-1.5));
    int[] arr = new int[5];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * 5) + 1;
    }
    System.out.println(Arrays.toString(arr));
    int max = arr[0];
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    System.out.println(max + " / " + min);

    System.out.println(Math.rint(1.2));
    System.out.println(Math.rint(1.5));
    System.out.println(Math.rint(-1.2));
    System.out.println(Math.rint(-1.5));

    int i3 = Integer.parseInt("10"); //문자열을 숫자로 변환(10진수)
    i3 = Integer.parseInt("1010", 2);System.out.println(i3);
    i3 = Integer.parseInt("1010", 8);System.out.println(i3);
    i3 = Integer.parseInt("1010", 16);System.out.println(i3);

    System.out.println(Integer.toBinaryString(10));
    System.out.println(Integer.toOctalString(10));
    System.out.println(Integer.toHexString(10));

  }
}