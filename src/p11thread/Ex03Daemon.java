package p11thread;

public class Ex03Daemon {
  static boolean autoSave = false;

  public static void main(String[] args) {
    Daemon daemon = new Daemon();
    daemon.setDaemon(true);
    daemon.start();
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) { }
      if (i==5) {
        autoSave = true;
      }
      System.out.println(i);
    }
  }

  static private class Daemon extends Thread {
    @Override
    public void run() {
      while (true) {
        try {
          Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        if (autoSave) {
          System.out.println("자동으로 저장되었습니다.");
        }
      }
    }
  }
}
