package p02method;

public class Ex05Operator {
  public static void main(String[] args) {
    System.out.println("논리 연산");
    System.out.println("||, &&, |, ^");
    boolean b1 = false;
    boolean b2 = (3 > 1) && (2 == 1);

    System.out.println("비교연산");
    System.out.println("==, >, <, >=, <=, !=");

    System.out.println("산술 연산");
    System.out.println("+, -, *, /, %");
    System.out.println(3 * 2);

    System.out.println("비트 연산자");
    System.out.println("&, |, ^, >>, <<, >>>");
    System.out.println("<< : 왼쪽이동, 빈공간 0으로 채움");
    System.out.println("<< : 오른쪽이동, 양수면 빈공간 0, 음수면 0으로 채움");
    System.out.println("<< : 오른쪽으로 이동, 빈공간 0으로 채움");

    System.out.println("대입 연산자");
    System.out.println("=, +=, -=, *=, /=, &=, ^=, |=, <<=, >>=, >>>=");

    System.out.println("단항 연산자");
    System.out.println("++, --");

    System.out.println("삼항 연산자");
    System.out.println(" ?: ");

  }
}
