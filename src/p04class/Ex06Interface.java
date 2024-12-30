package p04class;

public class Ex06Interface {
  public static void main(String[] args) {

  }
}

// Java에서는 다중상속을 허용하지 않는다 :: 중복된 속성에서 선택의 어려움.
//class Player extends Attack, Shield {
class Player implements Attackable, Shieldable {
  @Override
  public void attack() {
    System.out.println(Attackable.LEVEL + "공격!");
  }

  @Override
  public void shield() {
    System.out.println(Shieldable.LEVEL + "방어!");
  }

  @Override
  public void stop() {

  }

  // default도 중복될 경우 재정의
  @Override
  public void withdraw() {
    Attackable.super.withdraw();
  }
}

class Attack {
  int level;

  void attack() {
    System.out.println("돌격 앞으로!");
  }

  void stop() {
  }
}

class Shield {
  int level;

  void shield() {
    System.out.println("방어!");
  }

  void stop() {
  }
}

// interface에는 상수와 추상메서드만 정의
interface Attackable {
  public static final int LEVEL = 10;

  public abstract void attack();

  public abstract void stop();

  //완성된 메서드이지만 중복될 경우 implement한 클래스에서 재정의!
  public default void withdraw() {
    System.out.println("회수!");
  }

  // static이라서 중복되어도 재정의 불필요
  public static void start() {
    System.out.println("출발!");
  }
}

interface Shieldable {
  int LEVEL = 5;

  void shield();

  void stop();

  public default void withdraw() {
    System.out.println("회수!");
  }

  public static void start() {
    System.out.println("출발!");
  }
}