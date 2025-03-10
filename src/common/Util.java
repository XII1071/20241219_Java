package common;

public class Util {
  public static void typeof(Object obj) { //typeof(); 변수를 사용할때 타입하고 변수가 들어간다.
    System.out.println(obj.getClass().getSimpleName()); //void는 타입이 비어있다! return 값이 없다!
  }

  public static int rand(int seed) {
    return (int) (Math.random() * seed);

  }

}