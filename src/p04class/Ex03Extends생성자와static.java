
package p04class;

public class Ex03Extends생성자와static {
  public static void main(String[] args) {
    Parent parent = new Parent();
    Child child = new Child("일동");
    Child child2 = new Child(" 이동");
    Child child3 = new Child("삼동");

    System.out.println(parent);
    System.out.println(child);
    System.out.println(child2);
    System.out.println(child3);
    Parent.lastName = "김";
    //부모의 인스턴스 속성값이 초기화 되어도 자손 속성의 값이 동일하지 않다.
    //부모의 static 속성값이 초기화 되면 자손 속성의 값도 동일하다.
    System.out.println(parent);
    System.out.println(child);
    System.out.println(child2);
    System.out.println(child3);

    // new를 통해서 새로 초기화됨
    Parent p1 = new Child("사동");
    System.out.println(p1);
  }
}

class Parent {
  static String lastName; //성씨
  String firstName; // 실제 이름
  int age;

  // 생성자 3개
  // this() 또는 super()는 생성자안에서 오직 1개만 존재, 그리고 맨 윗줄 위치.
  public Parent() {
    lastName = "이";
  }

  public Parent(String firstName) {
    this(firstName, 1);
  }

  public Parent(String firstName, int age) {
    this();
    this.firstName = firstName;
    this.age = age;
  }

  @Override
  public String toString() {
    return lastName + "/" + firstName + "/" + age;
  }
}

class Child extends Parent {
  public Child(String firstName) {
    super(firstName); //Parent에 firstName을 입력하기 위한 생성자 필요
  }
}
