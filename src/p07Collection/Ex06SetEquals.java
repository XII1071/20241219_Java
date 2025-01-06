package p07Collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ex06SetEquals {
  public static void main(String[] args) {
    Set set = new HashSet<>();
    set.add(new Person("Foo", "010"));
    set.add(10);
    set.add(10);
    set.add("Hello Foo!");
    set.add("Hello Foo!");
    set.add(new Person("Foo", "010"));
    System.out.println(set);


  }
}

class Person {
  private String name, mobile;

  public Person(String name, String mobile) {
    this.name = name;
    this.mobile = mobile;
  }

  @Override
  public String toString() {
    return name + "/" + mobile;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mobile);
  }

  @Override
  public boolean equals(Object obj) {
    Person p = (Person) obj;
    if (this.name.equals(p.name) && this.mobile.equals(p.mobile)) {
      return true;
    } else {
      return false;
    }

  }
}