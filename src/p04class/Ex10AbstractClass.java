package p04class;

public class Ex10AbstractClass {
  public static void main(String[] args) {
    Rice rice = new Rice();
    // Item item = new Item();
    Item item = new Rice();
  }
}

// class 앞에 abstract가 붙으면 인스턴스 생성 불가
abstract class Item {
  int price;
}

// 추상클래스는 인스턴스(new)를 생성 못한다.
// 추상클래스는 인터페이스와 달리 클래스의 변수와 메서드 선언 가능.
abstract class Grocery extends Item {
  String subcategories; //세분류
  // 상수의 제어자는 인터페이스처럼 자동으로 추가 없다
  final int SUBNO = 1;

  abstract public void cate();

}

class Rice extends Grocery {
  @Override
  public void cate() {

  }
}