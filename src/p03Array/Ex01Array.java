package p03Array;

public class Ex01Array {
  public static void main(String[] args) {
    int[] score = new int[12];
    System.out.println(score.length);
    System.out.println(score);
    for (int i = 0; i < score.length; i++) {
      System.out.print(score[i]);
    }

    Object score2[];
    score2 = new Object[12];
    for (int i = 0; i < score2.length; i++) {
      System.out.print(score2[i]);
    }


  }
}

