package p07Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex02LinkedList {
  public static void main(String[] args) {
    List al = new ArrayList();
    List ll = new LinkedList();

    System.out.println("===순차적 추가===");
    System.out.println("al: " + addSequentially(al));
    System.out.println("ll: " + addSequentially(ll));

    System.out.println("===중간에 추가===");
    System.out.println("al: " + addMiddle(al));
    System.out.println("ll: " + addMiddle(ll));

    System.out.println("===중간에 삭제===");
    System.out.println("al: " + removeMiddle(al));
    System.out.println("ll: " + removeMiddle(ll));

    System.out.println("===순차적 삭제===");
    System.out.println("al: " + removeSequentially(al));
    System.out.println("ll: " + removeSequentially(ll));
    System.out.println(al);
    System.out.println(ll);
  }

  private static long removeMiddle(List list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      list.remove(i);
    }
    return System.currentTimeMillis() - start;
  }

  private static long removeSequentially(List list) {
    long start = System.currentTimeMillis();
//    for (int i = list.size() - 1; i >= 0; i--) {
//      list.remove(i); //index로 지움
//    }
    for (int i = 0; i < list.size(); i++) {
      list.remove(i); //index로 지움
    }
    return System.currentTimeMillis() - start;
  }

  private static long addMiddle(List list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      list.add(5000, i);
    }
    return System.currentTimeMillis() - start;
  }

  private static long addSequentially(List list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1_000_000; i++) {
      list.add(i);
    }
    return System.currentTimeMillis() - start;
  }
}