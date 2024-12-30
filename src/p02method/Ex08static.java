package p02method;

public class Ex08static {
  public static void main(String[] args) {
    Door eastDoor = new Door();
    Door westDoor = new Door();
    Door northDoor = new Door();
    Door southDoor = new Door();
    eastDoor.color = "yellow";
    westDoor.color = "red";
    northDoor.color = "blue";
    southDoor.color = "green";
    Door.key = "1234";
    System.out.println(eastDoor);
    System.out.println(westDoor);
    System.out.println(northDoor);
    System.out.println(southDoor);
  }
}

class Door {
  // static은 모든 인스턴스가 값을 공유
  static String key;
  // instance 변수는 인스턴스가 각각 값을 가짐.
  String color;

  @Override
  public String toString() {
    return key + "/" + color;
  }

  // static 속성, 메서드는 static 속성, 메서드 끼리만
  public static void open(String key) {
    if (Door.key.equals(key)) {
      System.out.println("Open the door.");
    }
    // static은 인스턴스 변수, 메서드 사용안됨: 초기화 시점 다름.
    // color = "orange";
  }

  // instance 속성, 메서드는 static, instance 상관 없음!
  public void close() {
    System.out.println("Close the door!");
  }
}