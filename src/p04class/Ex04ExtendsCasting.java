package p04class;

public class Ex04ExtendsCasting {
  public static void main(String[] args) {
    Father f1 = new Father("아빠", 40);
    Son s1 = new Son("아들", 10);
    System.out.println(f1);
    System.out.println(s1);
    System.out.println(s1.name);
    System.out.println(s1.age);
    // 상속 관계에서 형변환이 발생하면서, 속성이 중복되는 경우
    // 1) 자식 -> 부모

  }
}

class Father {
  int age;
  String name;

  // 생성자를 추가하면 더이상 JVM이 기본 생성자는 안만듬
  public Father(String name, int age) {

    this.name = name;
    this.age = age;

  }

  @Override
  public String toString() {
    return "Father:" + age + "/" + name;
  }
}

class Son extends Father {
  public Son(String name, int age) {
    super(name, age);
  }

  int age;
  String name;

  @Override
  public String toString() {
    return String.format("Son: %d / %s", super.age, super.name);
  }
}