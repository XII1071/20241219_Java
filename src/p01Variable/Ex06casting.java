package p01Variable;

import static common.Util.*; // static이 안붙으면 Util.typeof(b1 + b2); 으로 작성해야한다.
//import 다른패키지를 같이 사용할때 한다.

public class Ex06casting {
  public static void main(String[] args) {
    //boolean을 제외한 타입의 형변환이 일어난다.
    char c1 = 'a';
    System.out.println(c1 + 1);  // 연산할 경우 4byte 단위로 연산
    System.out.println((char) (c1 + 1));  // char 연산할때 int로 변환
    System.out.println(++c1);
    System.out.println(c1); // 단항연산일경우 형변환X, 값변화O
    byte b1 = 100;
    byte b2 = 100;
    System.out.println(b1 + b2); // 200
    typeof(b1 + b2); // Integer
    System.out.println((byte) (b1 + b2));
    // -56 (200 / 127 은 나머지 73 2진수에 73번쨰 값이 -56)
    short s1 = 1;
    short s2 = 1;
    System.out.println(s1 + s2); // 2
    typeof(s1 + s2); // Integer

    int i1 = 1000;
    long l1 = 1000; //묵시적 형변환 (변수의 범위 > 값의 법위)
    b1 = (byte) i1; //명시적 형변환 (변수의 범위 < 값의 법위)
    long l2 = 1_000_000_000_000_000L; //long 범위숫자뒤 L,l

    System.out.println(i1 + l2);
    typeof(i1 + l2); // l2가 long이여서 4byte가 넘어가기때문에 8byte로 계산
    float f1 = 0.11f;
    System.out.println(i1 + f1);
    typeof(i1 + f1);
    System.out.println(l1 + f1);
    typeof(l1 + f1);

  }
}

