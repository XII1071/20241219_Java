
package p04class;

public class Ex12innerClass {
  public static void main(String[] args) {
    Outer outer = new Outer();
    System.out.println(outer.iv);
//    Outer.InstanceInner ii = new Outer().new InstanceInner();
//    System.out.println(ii.iv);
//    ii.inner();
    Outer.StaticInner si = new Outer.StaticInner();
    System.out.println(si.iv);
    System.out.println(si.sv);
    System.out.println(Outer.StaticInner.sv);
    Outer.innerInterface oii = new Outer.innerInterface() {
      @Override
      public void innerInterfaceMethod() {
        System.out.println("내부 인터페이스의 메서드");
      }
    };
    Outer outer1 = new Outer();
    Outer outer2 = new Outer();
    Outer outer3 = new Outer();
    System.out.println(Outer.count);

  }
}

class Outer {
  static int count;
  int iv;
  String name;

  {
    count++;
  } //인스턴스 초기화 블럭 :: 생성자의 공통 수행 코드를 담음.

  static {

  } // static 초기화 블럭 :: 생성자의 공통 수행 코드를 static으로 담음.

  public Outer() {
    this("기본");
    iv = 1;
  }

  public Outer(String name) {
    this.name = name;
  }

  public Outer(int n1, int n2) {

  }

  class InstanceInner {
    int iv = 10;

    void inner() {
      System.out.println("inner():" + iv);
    }
  }

  static class StaticInner {
    int iv = 20;
    static int sv = 30;
  }

  interface innerInterface {
    void innerInterfaceMethod();
  }
}



