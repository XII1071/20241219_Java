package p08Generics;

public class Ex02GenericKeyValue {
  public static void main(String[] args) {
    GenericKV<String, Integer> genericKV = new GenericKV<>();
    genericKV.set("홍길동", 1111);
    // genericKV.set("홍길동", "1111");//타입 달라서 에러
    System.out.println("K:"+genericKV.getName());
    System.out.println("V:"+genericKV.getId());
  }
}

// generic type을 복수 개(2개 이상 가능)
class GenericKV<K, V> {
  K name; V id;

  void set(K name, V id) {
    this.name = name; this.id = id;
  }
  K getName() {return  name;}
  V getId() {return  id;}
}