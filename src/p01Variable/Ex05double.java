package p01Variable;

public class Ex05double {
  static float f1;  //0.0 4byte
  static double d1; //0.0 8byte

  public static void main(String[] args) {
    System.out.println(f1);
    System.out.println(d1);

    float f2 = 3.14f; //float 뒤에는 f, F 붙일것
    System.out.println(f2); // 초기화가 안됨
    //초기화 +선언 = 활당
    double d2 = 3.141592; // d 써도되고 안붙여도 됨
    System.out.println(d2);
    System.out.println(Float.MAX_VALUE);
    System.out.println(Float.MIN_VALUE);
    System.out.println(Double.MIN_VALUE);
    System.out.println(Double.MIN_VALUE);
    f2 = 0.123456789f;
    System.out.println(f2);
    d2 = 0.1234567890123456789;
    System.out.println(d2);
  }
}
