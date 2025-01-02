package p06Java기본패키지;

public class Ex03Wrapper {
  public static void main(String[] args) {
    //wrapper class로 인한 형변환 발생
    Object obj = 10;  //autoboxing: 기본형 -> 참조형
    Integer integer = Integer.valueOf(10); //기본형 -> 참조형
    System.out.println(obj == integer);
    System.out.println(obj.getClass().getSimpleName());
    System.out.println(((Object) integer).getClass().getSimpleName());
    int i1 = (int) obj; //unboxing: 참조형 -> 기본형
    int i2 = integer;  // 참조형 -> 기본형
    int n1 = Integer.parseInt("123"); //문자열을 int로 형변환
    int n2 = Integer.valueOf("123");  //문자열을 Integer로 형변환
    System.out.println(n2);
    Integer integer2 = (Integer) 1000;

    //참조형 변수가 숫자일 때 크면 1 리턴, 작으면 -1 리턴, 같으면 0
    System.out.println(Integer.valueOf(3).compareTo(3));
    System.out.println(Integer.valueOf(3).compareTo(1));
    System.out.println(Integer.valueOf(3).compareTo(5));

  }
}