package p10IO;

import java.io.*;
import java.util.ArrayList;

public class Ex06Serializable {
  public static void main(String[] args) {
    User u1 = new User("LGH", 10);
    User u2 = new User("KGH", 11);
    ArrayList<User> list = new ArrayList<>();
    list.add(u1);
    list.add(u2);
    String exportFile = "UserInfo.ser";
    try (
        FileOutputStream fos = new FileOutputStream(exportFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // instance의 상태를 프로세스 밖으로 내보내기 함.
        ObjectOutputStream oos = new ObjectOutputStream(bos);
    ) {
      oos.writeObject(u1);oos.writeObject(u2);oos.writeObject(list);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try (
        FileInputStream fis = new FileInputStream(exportFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        // instance의 상태를 프로세스 밖으로 내보내기 함.
        ObjectInputStream ois = new ObjectInputStream(bis);
    ) {
      User get1 = (User) ois.readObject();
      User get2 = (User) ois.readObject();
      ArrayList<User> get3 = (ArrayList<User>) ois.readObject();
      System.out.println(get1);
      System.out.println(get2);
      System.out.println(get3);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

class User implements Serializable {
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