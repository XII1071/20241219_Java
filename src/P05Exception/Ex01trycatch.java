package P05Exception;

public class Ex01trycatch {
  public static void main(String[] args) {
    System.out.println(1);
    System.out.println(2);
    System.out.println(3);
    try {
      System.out.println(10 / 10);
      System.out.println(4);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println(5);
    } finally { //try 영역을 실행 후 무조건 마무리하는 곳
      System.out.println(6);
      System.out.println(7);
    }
  }
}
