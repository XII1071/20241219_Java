package p06Java기본패키지;

public class Ex01Object {
  public static void main(String[] args) {
    Object obj = new Object();
    // 1) toString()
    System.out.println("obj" + obj); //toString
    System.out.println("obj" + obj.toString()); //toString
    System.out.println(System.identityHashCode(obj));
    MyObj myObj1 = new MyObj();
    System.out.println(myObj1);
    System.out.println(System.identityHashCode(myObj1));
    MyObj myObj2 = new MyObj();
    System.out.println(myObj2);
    System.out.println(System.identityHashCode(myObj2));
    System.out.println("myObj1 == myObj2 : " + (myObj1 == myObj2));
    System.out.println("myObj1 equals(myObj2) : " + (myObj1.equals(myObj2)));
  }
}

class MyObj {
  // getClass(), hashCode(), equals(Object obj), clone(), toString(),
  // notify(), notifyAll(), wait(), finalize()
  int val = 100;

  @Override
  public String toString() {
    return "val: " + val;
  }

  @Override // 자 -> 부- > 자
  public boolean equals(Object obj) {
    MyObj myObj = null;
    if (obj instanceof MyObj) {
      // 변수명 instanceof 타입
      myObj = (MyObj) obj;
    }
    return myObj.val == this.val;
  }
}
