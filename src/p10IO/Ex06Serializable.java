
package p10IO;

import java.util.ArrayList;

public class Ex06Serializable {
  public static void main(String[] args) {
    User u1 = new User("LGH", 10);
    User u2 = new User("KGH", 11);
    ArrayList<User> list = new ArrayList<>();
    list.add(u1);
    list.add(u2);
  }
}

class User {
  private String name;
  private int age;

  public User() {
    this("Unknown", 10);
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return name + "/" + age;
  }
}
