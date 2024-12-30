package p04class;

public class Ex04ExtendsCasting {
  public static void main(String[] args) {
    Father f1 = new Father("아빠", 40);
    Son s1 = new Son("아들", 10);
    System.out.println(f1);
    System.out.println(s1);
    System.out.println(s1.name); //생성자의 super때문에 Son의 속성에 초기화 안됨.
    System.out.println(s1.age);

    Father f2 = new Father();
    Son s2 = new Son();
    System.out.println(f2);
    System.out.println(s2);

    // 상속 관계에서 형변환이 발생하면서, 속성이 중복되는 경우
    // 1) 자식 -> 부모
    Father f3 = new Son(); //super가 기본이라서 부모에 값을 못 넘겨 주기 때문
    System.out.println(f3);  //toString()::메서드는 자식꺼
    System.out.println(f3.age);//age::멤버변수는 부모꺼
    // 형변환이 일어난 경우 메서드는 자식꺼, 변수는 부모꺼

  }
}

class Father {
  int age;
  String name;

  // 생성자를 추가하면 JVM이 더이상 기본 생성자는 안만듦.
  public Father(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Father() {
    age = 42;
  }

  @Override
  public String toString() {
    return "Father: " + age + " / " + name;
  }
}

class Son extends Father {
  public Son() {
    age = 12;
  }

  public Son(String name, int age) {
    super(name, age);
  }
//  int age;
//  String name;

  @Override
  public String toString() {
//    return String.format("Son: %d / %s", super.age, super.name);
    return String.format("Son: %d / %s", age, name);
  }
}