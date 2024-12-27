package p04class;

public class Ex02ExtendsSub {
  public static void main(String[] args) {
    Father father = new Father(40);
    Child child = new Child();
    System.out.println(father.age);
    System.out.println(child.age);
    System.out.println(father.name);
    System.out.println(child.name);
  }
}

class Father {
  public Father(int age) {
    this.age = age;
  }

  String name;
  int age;

  void doing() {
  }
}

class Child extends Father {
  public Child() {
    super(0);
  }

  String name;

  @Override
  void doing() {
  }
}