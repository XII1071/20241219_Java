package p07Collection;

import java.util.*;

public class Ex10Collections {
  public static void main(String[] args) {
    List<TheRich> list = new ArrayList<>();
    list.add(new TheRich("이부자", 1, 100, 100, 90));
    list.add(new TheRich("정부자", 2, 90, 98, 84));
    list.add(new TheRich("강부자", 1, 100, 91, 96));
    list.add(new TheRich("남부자", 2, 99, 91, 100));
    System.out.println(list);
    Collections.shuffle(list);
    for (TheRich rich : list) {
      System.out.println(rich);
    }
    System.out.println();
    Collections.sort(list, new SortingInfo());
    for (TheRich rich : list) System.out.println(rich);
  }
}

class SortingInfo implements Comparator {
  @Override
  public int compare(Object o1, Object o2) {
    if (o1 instanceof TheRich && o2 instanceof TheRich) {
      TheRich r1 = (TheRich) o1; // 자부자
      TheRich r2 = (TheRich) o2;
      int result = r1.no - r2.no; // 오름차순
      if (result == 0)
        return r1.getAsset() - r2.getAsset() * -1; // 내림차순
      return result;
    }
    return -1;
  }
}

class TheRich {
  String name;
  int no;
  int cash;
  int real;
  int stock;


  public TheRich(String name, int no, int cash, int real, int stock) {
    this.name = name;
    this.no = no;
    this.cash = cash;
    this.real = real;
    this.stock = stock;

  }

  int getAsset() {
    return cash + real + stock;
  }

  @Override
  public String toString() {
    return name + "/" + no + "/ $" + getAsset();
  }
}
