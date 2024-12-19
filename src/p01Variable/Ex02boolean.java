package p01Variable;

public class Ex02boolean {
  static boolean toggle; // false 기본값

  public static void main(String[] args) {
    System.out.println(toggle);
    boolean power = true;

    if (!power) {
      System.out.println("power:" + power);
    }

    // wrapper class Boolean 존재
    System.out.println(Boolean.valueOf("TruE"));
    System.out.println(Boolean.valueOf("1"));
    System.out.println(Boolean.parseBoolean("1"));
  }
}