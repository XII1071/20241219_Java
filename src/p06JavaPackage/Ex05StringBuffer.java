package p06JavaPackage;

public class Ex05StringBuffer {
  public static void main(String[] args) {
    System.out.println("======String======");
    String str = "hello";
    System.out.println(str.hashCode());
    str = str + " world";
    System.out.println(str);
    System.out.println(str.hashCode());

    System.out.println("===StringBuffer===");
    StringBuffer sb = new StringBuffer("hello");
    System.out.println(sb.hashCode());
    sb.append(" world");
    System.out.println(sb.hashCode());
    System.out.println(sb.length());
    System.out.println(sb.capacity());
    System.out.println(sb.delete(5,12));
    System.out.println(sb.insert(5," Java"));
    System.out.println(sb.hashCode());
    System.out.println(sb.reverse());
    System.out.println(sb);

    // 매우 많은 문자열을 누적 해야 하는 경우
    StringBuilder sbuilder = new StringBuilder();
    for (int i = 0; i < 10000; i++) {
      sbuilder.append("hello ");
      // String 10000번을 메모리 누수가 더 큼
    }
    System.out.println(sbuilder);
  }
}
