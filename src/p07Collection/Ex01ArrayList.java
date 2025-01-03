package p07Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex01ArrayList {
  public static void main(String[] args) {
    List listInt = new ArrayList<>();
    listInt.add(0);
    listInt.add(1);
    listInt.add(2);
    listInt.add(true);
    listInt.add("hello");
    System.out.println(listInt);

    List list3 = new ArrayList();
    for (int i = 0; i < 10; i++) {
      list3.add(i + 1);
    }
    System.out.println(list3);


    List list = new ArrayList<>();
    Member m1 = new Member("1", "강지원", "lgh");
    list.add(m1);
    list.add(new Member("1", "G1", "mgh"));
    list.add(new Member("1", "지원", "rgh"));
    System.out.println(list);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    for (Object o : list) {
      System.out.println((Member) o);
    }
    Iterator it = list.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}

class Member {


  private String id, name, pass;

  public Member(String pass, String name, String id) {
    this.id = id;
    this.name = name;
    this.pass = pass;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  @Override
  public String toString() {
    return String.format("Member{id=%s, name=%s,pass=%s}", id, name, pass);
  }
}
