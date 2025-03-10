package p04class;

public class Ex01classUse {
  public static void main(String[] args) {
    // 클래스를 설계할 경우 공통된 속성을 어떤 식으로 전개하느냐? 재사용 목적
    // 1. has-A 관계 :: 포함 관계
    // 2. is-A 관계  :: 상속 관계

    // has-A관계 :: 자동차는 엔진이다(X) / 엔진은 자동차이다(X)
    Car car = new Car();
    car.model = "Hyundae";
    System.out.println(car); //engine은 초기화 안됨. null
    car.engine = new Engine();
    car.engine.model = "알파엔진";

    System.out.println(car.engine.gitong);
    System.out.println(car.model);
    System.out.println(car.engine.model);

    // is-A 관계 :: 소나무는 나무다(O) / 나무는 소나무다(X)
    Tree tree = new Tree();
    PineTree pineTree = new PineTree();
    // 상속관계일 경우 클래스의 형변환 있음.
    Tree tree2 = new PineTree();
  }
}

class Car {
  Engine engine; //클래스 안의 클래스 변수
  String model;

  @Override
  public String toString() {
    return model + "/" + engine;
  }
}

class Engine {
  int gitong;
  String model;
}

//자바에서는 다중 상속이 안됨(오직 단일 상속)
//class SportsCar extends Car, Engine{}

class Tree { }
class PineTree extends Tree { }