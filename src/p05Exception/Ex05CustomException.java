package p05Exception;

public class Ex05CustomException {
  public static void main(String[] args) {
    try {
      throw new MyException();
    } catch (MyException e) {
      System.out.println(e.getMessage());
    }
  }
}

class MyException extends Exception {
  public MyException() {
    super("나의 Exception 처리");
  }
}
