package p07Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex09HashMap응용 {
  private static Map phoneBook = new HashMap();

  public static void main(String[] args) {
    addPhone("친구", "김길동", "010-1111-1111");
    addPhone("친구", "이길동", "010-1111-1112");
    addPhone("친구", "강길동", "010-1111-1113");
    addPhone("친구", "박길동", "010-1111-1114");
    addPhone("마트", "010-1111-1115");

    printPhoneBook(phoneBook);
  }

  private static void printPhoneBook(Map phoneBook) {
    Iterator it = phoneBook.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry) it.next();
      Map subBook = (HashMap) entry.getValue();
      System.out.printf("== %s [%d 개] == %n", entry.getKey(), subBook.size());
      Iterator subIt = subBook.entrySet().iterator();
      while (subIt.hasNext()) {
        Map.Entry subEntry = (Map.Entry) subIt.next();
        System.out.printf("이름: %s / Tel: %s \n", subEntry.getValue(), subEntry.getKey());
      }
      System.out.println();
    }
  }

  private static void addPhone(String name, String tel) {
    addPhone("기타", name, tel);
  }

  private static void addPhone(String group, String name, String tel) {
    addGroup(group);
    HashMap book = (HashMap) phoneBook.get(group);
    book.put(tel, name);
  }

  private static void addGroup(String group) {
    if(!phoneBook.containsKey(group)) phoneBook.put(group, new HashMap());
  }
}
