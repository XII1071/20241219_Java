package p04class;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * [ 제어자(Modifier) ]
 * class  :: public,(default),final,abstract
 * method :: All(public,protected,default,private),final,abstract,static
 * 멤버 변수 :: All, final, static
 * 지역 변수 :: final
 */
public class Ex11Modifier {
  // public :: 같은 패키지 內와 다른 패키지에서도 참조 가능
  // protected :: 같은 패키지 內와 다른 패키지에서 상속 받을 경우 참조 가능
  // default :: 같은 패키지 내에서만 사용 가능
  // private :: 클래스 내에서만 사용 가능
  public int publicVar=0;
  protected int protectedVar=1;
  int defaultVar=2;
  private int privateVar=3;
  public void publicMethod(){System.out.println("publicMethod");}
  protected void protectedMethod(){System.out.println("protectedMethod");}
  void defaultMethod(){System.out.println("defaultMethod");}
  private void privateMethod(){System.out.println("privateMethod");}

  final void finalMethod() {}

  public static void main(String[] args) {
    int value = 10;
    JButton btn = new JButton("Click");
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // value=20;//메서드의 지역변수가 매서드 내부 익명클래스에 사용할때 Effectively Final 적용
        int tmp = value;  // 변경이 안됨으로 다른 지역변수에 할당하여 사용
        tmp--;
      }
    });
  }
}

// class에 final을 붙이면 상속 불가
final class Human {}
//class AI extends Human {}

class Person {
  // method에 final을 붙이면 override 불가
  final void finalMethod() {}
}
class Employee extends Person {
//  @Override
//  void finalMethod(){System.out.println();}
}