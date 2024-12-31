package p04class;

public class Ex09FunctionalInterface {
  public static void main(String[] args) {
    CustomClass customClass = new CustomClass();

    // 인터페이스에 클래스를 형변환 하는데, 인터페이스를 익명클래스로 만든 후 형변환 함.
    CustomInterface customInterface = new CustomInterface() {
      @Override
      public void interfaceMethod() {
        System.out.println("익명클래스의 메서드 재정의");
      }

      @Override
      public void interfaceMethod2() {
        System.out.println("익명클래스의 메서드 재정의2");
      }
    };
    MyFunctionalInterface my = new MyFunctionalInterface() {
      @Override
      public void myCall() {
        System.out.println("myCall");
      }
    };
  }
}

// 인터페이스 안에 추상메서드가 오직 하나만 있는 경우 Functional Interface.
@FunctionalInterface
interface MyFunctionalInterface {
  void myCall(); // 추상메서드가 오직 1개

  default void myDefault() {
  } // default 메서드는 상관 없음.

  static void myStatic() {
  } // static 메서드는 상관 없음.
}

//@FunctionalInterface //추상 메서드가 2개 이상이라서 적용 안됨.
interface CustomInterface {
  void interfaceMethod();

  void interfaceMethod2();
}

class CustomClass implements CustomInterface {
  @Override
  public void interfaceMethod() {
    System.out.println("interfaceMethod");
  }

  @Override
  public void interfaceMethod2() {
    System.out.println("interfaceMethod2");
  }
}