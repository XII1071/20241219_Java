package p04class;

public class Ex13SingletonPattern {
  public static void main(String[] args) {
    Generalton g1 = new Generalton();
    Generalton g2 = new Generalton();
    Generalton g3 = new Generalton();
    System.out.println(g1);
    System.out.println(g2);
    System.out.println(g3);
    System.out.println(String.format("%d, %d, %d",g1.cnt,g2.cnt,g3.cnt));
    g1.cnt = 10;
    System.out.println(String.format("%d, %d, %d",g1.cnt,g2.cnt,g3.cnt));

//    Singleton singleton = new Singleton(); // 기본 생성자가 private
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    System.out.println(s1+":"+Singleton.cnt);
    System.out.println(s2+":"+Singleton.cnt);
  }
}

class Generalton {
  static int cnt;
  public Generalton() {
    cnt++;
  }
}
class Singleton {
  static int cnt;
  static private Singleton singleton;
  private Singleton(){}

  static public Singleton getInstance() {
    if(singleton == null) {
      singleton = new Singleton();
      cnt++;
    }
    return singleton;
  }
}