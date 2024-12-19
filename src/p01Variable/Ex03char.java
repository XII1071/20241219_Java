package p01Variable;

public class Ex03char {
  static char c;

  public static void main(String[] args) {
    System.out.println(c);
    char c1 = 'a';
    c1 = 'a';
    c1 = '0';
    c1 = ' '; //기본 값
    c1 = '\u0000'; // 헥사코드로서 공백과 동일
    System.out.println(c1);
    System.out.println((int) c1); //int 타입으로 변환 ascii 코드로 나옴
    System.out.println((char) 98); //숫자를 char로 변환

// char에 기본값은 공백
//    c1= ''; char 빈문자열은 값이 될 수 없다
//    c1= 'ab';// char는 반드시 글자를 한글자만 사용.
    // wrapper Character 존재
    System.out.println(Character.valueOf('a'));
  }
}
