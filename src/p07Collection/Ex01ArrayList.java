package p07Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex01ArrayList {
  public static void main(String[] args) {
    List listInt = new ArrayList(); // 기본 생성자로 ArrayList 생성
    List listCopy = new ArrayList(listInt); //Collection으로 ArrayList 생성
    List listCapacity = new ArrayList(10); // 크기로 ArrayList 생성
    listInt.add(0);listInt.add(1);listInt.add(2);
    listInt.add(true);listInt.add("hello");
    System.out.println(listInt);

    List list3 = new ArrayList();
    for (int i = 0; i < 10; i++) {
      list3.add(i + 1);
    }
    System.out.println(list3);


    List list = new ArrayList<>();
    Member m1 = new Member("lgh", "이규훈","1");
    list.add(m1);
    list.add(new Member("mgh", "마규훈","1"));
    list.add(new Member("rgh", "라규훈","1"));
    System.out.println(list);

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    for (Object o : list) {
      System.out.println((Member)o);
    }

    Iterator it = list.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    List<Integer> lotto = new ArrayList<>();
    while (lotto.size() < 6) {
      int ball = (int) (Math.random() * 45) + 1;
      if (lotto.contains(ball)) continue;

      lotto.add(ball);
    }
    System.out.println(lotto);
  }
}

class Member {
  private String id, name, pass;

  public Member(String id, String name, String pass) {
    this.id = id;this.name = name;this.pass = pass;
  }

  public String getId() {return id;}
  public void setId(String id) {this.id = id;}
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}
  public String getPass() {return pass;}
  public void setPass(String pass) {this.pass = pass;}

  @Override
  public String toString() {
    return String.format("id=%s,name=%s,pass=%s",id, name, pass);
  }
}