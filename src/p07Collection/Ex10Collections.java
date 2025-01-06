package p07Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
