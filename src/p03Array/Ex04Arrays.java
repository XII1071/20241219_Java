package p03Array;

import java.util.Arrays;

public class Ex04Arrays {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int[] b = a;

//    1) shallow copy
//    System.out.println(a);
//    System.out.println(b);
//    System.out.println(Arrays.toString(a));
//    System.out.println(Arrays.toString(b));
//
//    a[0] = 5;
//    System.out.println(Arrays.toString(a));
//    System.out.println(Arrays.toString(b));

//    2) deep copy 1
//    b = a.clone();
//    System.out.println(a);
//    System.out.println(b);
//    System.out.println(Arrays.toString(a));
//    System.out.println(Arrays.toString(b));
//
//    a[0] = 5;
//    System.out.println(Arrays.toString(a));
//    System.out.println(Arrays.toString(b));

    b = new int[a.length];
    System.out.println(a);
    System.out.println(b);
//   3) deep copy 2
//    System.arraycopy(a,0,b,0,b.length);

//   4) Arrays 기타 메서드
//    b = Arrays.copyOf(a, a.length);
//    b = Arrays.copyOfRange(a, 1, a.length);
    Arrays.fill(b, 7);
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));

    a[0] = 5;
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));

    Arrays.sort(a);

    // enhanced for loop
    for (int item : a) {
      System.out.print(String.format("%3d", item));
    }

  }
}