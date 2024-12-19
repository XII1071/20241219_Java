package p01Variable;

public class Ex04integer {
  byte b1;  //0, 1byte
  short s1; //0, 2byte
  int i1;   //0, 4byte
  long l1;  //0, 8byte
  //모두 기본값 0

  public static void main(String[] args) {
    Ex04integer e4 = new Ex04integer();
    System.out.println(e4.b1);
    System.out.println(e4.s1);
    System.out.println(e4.i1);
    System.out.println(e4.l1);
    e4.l1 = 1_000_000_000_000_000l; //int 보다 큰숫자뒤에는 L,l
    System.out.println(e4.l1);
    

    System.out.println(Byte.MIN_VALUE);
    System.out.println(Byte.MAX_VALUE);
    System.out.println(Short.MAX_VALUE);
    System.out.println(Short.MAX_VALUE);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Long.MAX_VALUE);
    System.out.println(Long.MAX_VALUE);
  }
}
