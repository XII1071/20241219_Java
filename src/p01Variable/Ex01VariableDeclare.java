package p01Variable;

public class Ex01VariableDeclare {
  //  int num; // 재선언이 안됨
  static int num; //  -> 1-1
  String name;

  // 변수의 재선언이 안됨.
  //  int num;

  // 변수 선언 후 초기화는 메서든 안에서 가능
  //  num = 100;

  // 변수의 할당(선언과 초기화)시에는 초기화 가능
  int sum = 0;

  public static void main(String[] args) {
    int tot = 10;
    num = 1000; //    -> 이렇게 쓸거면 1-1에 선언후 해야한다.
    Ex01VariableDeclare e = new Ex01VariableDeclare(); //사용하는 시점은 여기에 초기화가 됨
//    e.num = 10; 타입이 안맞아서 오류 문자열로 처리해야합
    e.name = "10";
  }
}
