package p06JavaPackage;

import java.util.Objects;

public class Ex01Object {
  public static void main(String[] args) {
    Object obj = new Object();
    // 1) toString()
    System.out.println("obj: " + obj); //toString
    System.out.println("obj: " + obj.toString()); //toString
    System.out.println(System.identityHashCode(obj));
    MyObj myObj1 = new MyObj();
    System.out.println(myObj1);
    System.out.println(System.identityHashCode(myObj1));
    MyObj myObj2 = new MyObj();
    System.out.println(myObj2);
    System.out.println(System.identityHashCode(myObj2));
    System.out.println("myObj1 == myObj2 : " + (myObj1 == myObj2));
    System.out.println("myObj1.equals(myObj2) : " +(myObj1.equals(myObj2)));
    MyObj myObj3 = null;
    try {
      myObj3 = (MyObj) myObj1.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("myObj1 == myObj3 : " + (myObj1 == myObj3));
    System.out.println("myObj1.equals(myObj3) : " +(myObj1.equals(myObj3)));
  }
}

class MyObj implements Cloneable {
  //getClass(),hashCode(),equals(Object obj),clone(),toString(),
  //notify(),notifyAll(),wait(),finalize()
  int val = 100;

  @Override
  public String toString() {
    return "val: " + val;
  }

  @Override
  public boolean equals(Object obj) {
    MyObj myObj = null;
    if(obj instanceof MyObj) {
      myObj = (MyObj) obj;
    }
    return myObj.val == this.val;
  }

  // clone() 사용위해 Cloneable을 implement하고 hashCode(), clone() 재정의.
  @Override
  public int hashCode() {
    return Objects.hash(val);
  }
  @Override
  protected Object clone() throws CloneNotSupportedException {
    Object obj = null;
    try {
      obj = super.clone(); //MyObject => Object (자부)
    } catch (CloneNotSupportedException e) { }
    return obj;
  }
}