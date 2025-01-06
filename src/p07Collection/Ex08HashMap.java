package p07Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex08HashMap {
  public static void main(String[] args) {
    Map map = new HashMap();
    map.put("admin", 1);
    map.put("user", 1);
    map.put("user", 2);
    System.out.println(map);
    if (!map.containsKey("root")) map.put("root", 1);
    System.out.println(map);

    // 각각의 원소의 대하여 접근하려고 할 때
    // 1. key&value를 동시에
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry) it.next();
      System.out.println(String.format("key: %s / value:%s",
          entry.getKey(), entry.getValue())
      );
    }
    // 2. key만 들고올 때
    it = map.keySet().iterator();
    while (it.hasNext()) {
      String key = (String) it.next();
      System.out.println(String.format("key: %s / value:%s",
          key, map.get(key))
      );
    }
    // 3. value만 들고올 때
    it = map.values().iterator();
    while (it.hasNext()) {
      int pass = (int) it.next();
      System.out.println(pass);
    }
    map.remove("root");
  }
}





/*stack은 push, queue offer*/

/*해당되는 컬렉션 이터렉터 */
