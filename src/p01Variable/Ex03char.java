package p01Variable;

public class Ex03char {
  static char c;

  public static void main(String[] args) {
    System.out.println(c);
    char c1 = 'A';
    c1 = 'a';
    c1 = '0';
    c1 = ' '; // 기본값
    c1 = '\u0000'; // 헥사 코드로서 공백과 동일
//    c1 = ''; //char 빈문자열은 값이 될 수 없다.
//    c1 = 'ab'; //char 반드시 글자를 한글자 만 사용.
    System.out.println(c1);
    System.out.println((int) c1);
    System.out.println((char) 98);

    // wrapper Character  존재
    System.out.println(Character.valueOf('a'));
  }
}
