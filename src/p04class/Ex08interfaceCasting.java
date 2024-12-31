package p04class;

public class Ex08interfaceCasting {
  public static void main(String[] args) {

    // 상속 :: 수직적인 관계를 형변환
    mammals[] mammalsArr = {new Elephant(), new Cat(), new Bat()};
    Birds[] BirdsArr = {new Eagle(), new Owl(), new Duck()};
    for (int i = 0; i < mammalsArr.length; i++) {
      System.out.println(mammalsArr[i]); // 클래스에 정의된 것(모두) 사용가능
    }

    // interface 형변환 :: 수평적인 관계를 형변환
    Groundable[] groundablesArr = {new Elephant(), new Cat(), new Duck()};
    Flyable[] flyables = {new Eagle(), new Owl(), new Bat()};
    for (int i = 0; i < flyables.length; i++) {
      flyables[i].fly(); // 인터페이스에 정의된 것 (메서드, 상수)만 사용가능하지만,
      // 메서드에서 클래스의 변수외 메서드에 접근 가능
    }
  }
}

interface Groundable {
  void walk();
}

interface Flyable {
  void fly();
}


class mammals {
}

class Birds {
}

class Elephant extends mammals implements Groundable {
  // interface의 추상메서드는 제어자가 public이므로 재정의시 그보다 표현범위가 크거나 같아야함.
  public void walk() {
    System.out.println(name + "쿵쿵");
  }

  String name = "코끼리";
}

class Cat extends mammals implements Groundable {
  @Override
  public void walk() {
    System.out.println(name + "꾹꾹");
  }

  String name = "고양이";
}

class Bat extends mammals implements Flyable {
  @Override
  public void fly() {
    // 추상메서드를 implement한 클래스라서 메서드만 사용할 거 같지만
    // 실제로는 추상메서드에서 다른 메서드, 변수등을 불러서 사용 가능.
    System.out.println(name + "파닥파닥");
    System.out.println(Math.random() * 10);
  }

  String name = "박쥐";
}

class Duck extends Birds implements Groundable {
  @Override
  public void walk() {
    System.out.println(name + "뒤뚱뒤뚱");
  }

  String name = "오리";

}

class Eagle extends Birds implements Flyable {
  @Override
  public void fly() {
    System.out.println(name + "펄럭펄럭");
  }

  String name = "독수리";

}

class Owl extends Birds implements Flyable {
  @Override
  public void fly() {
    System.out.println(name + "부엉부엉");
  }

  String name = "부엉이";

}