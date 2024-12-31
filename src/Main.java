// class 밖으로 변수와 메서드를 선언할 수 없다
//int tot =10;
//void eat(){} 잘못된 선언

import p04class.Ex10Modifier;

class Foo { //구조를 만든다 class {}안에는 멤버변수와 메서드만 가능합니다
  String name; //멤버 변수 (속성)

  // 자동 정렬 : ctrl + alt + l
  // 자동 중괄호 생성 : ctrl + shift + enter
  void sleep() {
    for (int i = 0; i < 2; i++) {
      System.out.println(name + "쿨쿨~");

    }
  }
  // main()는 같은 파일에서는 하나만 존재해야한다.

//  public static void main(String[] args) {
//    Foo foo = new Foo(); //메인 메서드에서 클래스 Foo를 당겨와서 foo로 인스턴스를 함
//    foo.name = "곰돌이"; //이름을 부여
//    foo.sleep(); // 실행
//  }
}

// public 붙은 클래스는 반드시 파일명과 일치! 단 하나의 class에만 붙일 수 있음
public class Main {
  public static void main(String[] args) {
    Ex10Modifier ex = new Ex10Modifier();
    ex.publicVar = 100;
    ex.publicMethod();

  }

  class ExTemp extends Ex10Modifier {
    @Override
    protected void protectedMethod() {
      super.protectedMethod();
      System.out.println(protectedVar);
    }
  }
}