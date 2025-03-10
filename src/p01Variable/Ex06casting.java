package p01Variable;

import static common.Util.*;

public class Ex06casting {
  public static void main(String[] args) {
    //boolean을 제외한 타입의 형변환이 일어난다.
    char c1 = 'a';
    System.out.println(c1 + 1); // 연산할 경우 4byte단위로 연산
    System.out.println((char) (c1 + 1)); // 연산할 경우 4byte단위로 연산
    System.out.println(++c1);
    System.out.println(c1); // 단항연산일경우 형변환 無,값변화 有
    byte b1 = 100;
    byte b2 = 100;
    System.out.println(b1 + b2);
    typeof(b1 + b2);
    System.out.println((byte) (b1 + b2));

    short s1 = 1;
    short s2 = 1;
    System.out.println(s1 + s2);
    typeof(s1 + s2);

    int i1 = 1000;
    long l1 = 1000; // 묵시적 형변환(변수의 범위 > 값의 범위)
    b1 = (byte) i1; // 명시적 형변환(변수의 범위 < 값의 범위)
    long l2 = 1_000_000_000_000_000L;//long범위 숫자뒤 L,l

    System.out.println(i1 + l2);
    typeof(i1 + l2);
    float f1 = 0.11f;
    System.out.println(i1 + f1);
    typeof(i1 + f1);
    System.out.println(l1 + f1);
    typeof(l1 + f1);
  }

}
