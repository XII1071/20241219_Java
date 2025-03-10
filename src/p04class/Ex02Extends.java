package p04class;

public class Ex02Extends {
  public static void main(String[] args) {
    Marine marine = new Marine();
//    marine.tribe = "Terran";
    Marine marine2 = new Marine();
//    marine2.tribe = "Terran";
    System.out.println(marine);

    Marine marine3 = new Marine();
    Marine marine4 = new Marine();
    System.out.println(marine.armor);
    System.out.println(marine.hp);
    marine.move();marine2.move();marine3.move();
    marine4.pattrol();

    Zealot z1 = new Zealot();
    System.out.println(z1);
    String s = new String("hello");
    System.out.println(s);
  }
}

class Unit {
  int hp;  String tribe;  String name;
  public Unit(String tribe, int hp, String name) {
    this.tribe = tribe;this.hp = hp;this.name = name;
  }
  void move(){};  void stop(){}

  @Override
  public String toString() {
    return String.format("종족: %s, 이름: %s, hp: %d", tribe, name, hp);
  }
}

class Terran extends Unit {
  public Terran(int hp, String name) {
    super("테란", hp, name); // super()와 this()는 같이 사용 안됨.
    tribe = "테란"; super.hp = hp; super.name = name;//위와 동일한 표현
  }
}
class Marine extends Terran {
  public Marine() {
    super(60, "마린");
  }

  int armor;
  void pattrol() {}
}

class Protoss extends Unit {
  public Protoss(int hp, String name) {
    super("프로토스", hp, name);
  }
}

class Zealot extends Protoss {
  public Zealot() {
    super(40, "질럿");
  }

  void attack() {

  }
}

class creature {
}