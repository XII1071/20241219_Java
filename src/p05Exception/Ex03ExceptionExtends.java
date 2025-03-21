package p05Exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex03ExceptionExtends {
  public static void main(String[] args) {
    Child child = new Child();
    child.method();
  }
}

class Parent {
  protected void method() throws ClassCastException, ArithmeticException {}
}
class Child extends Parent {
  // 오버라이드시 주의 사항
  // 1) 접근 제어자는 같거나 넓어야 한다.
  // 2) throws는 exception의 개수가 없거나 적거나 같거나, 단 새로운 거 추가안됨.
  @Override
  public void method() {
    super.method();
  }
}