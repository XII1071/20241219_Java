package p02method;

public class Ex02overloading {
  public static void main(String[] args) {

  }

  //overloading :: 메서드의 다양한 매개변수를 활용할수 있게 이름을 단일화 한다. (add 이름은 같은데 매개변수가 다름)
  // 메서드의 ::
  //이 :: 이름은 같아야함
  //매 :: 매개변수 타입과 순서가 달라야한다.
  //리 :: 리턴타입은 상관 없다.
  static String add(String s1, String s2) {
    return s1 + " " + s2;
  }

  int add(int n1, int n2) {
    return n1 + n2;
  }

  //  int add(int num1, int num2) {
  //    return num1 + num2;
  String add(int n2, String n1) {
    return n1 + n2;

  }
}

