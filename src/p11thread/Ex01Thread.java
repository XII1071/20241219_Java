package p11thread;

public class Ex01Thread {
  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    myThread.start();
    Thread t1 = new Thread(new MyRunnable());
    t1.start();

    for (int i = 10; i > 0; i--) {
      try {
        Thread.sleep(500);
        System.out.println("for " + i);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

  }
}

class MyThread extends Thread {
  @Override
  public void run() {
    try {
      System.out.println("MyThread started");
      Thread.sleep(1000);
      System.out.println("MyThread end");
    } catch (InterruptedException e) {

    }
  }
}

class MyRunnable implements Runnable {
  @Override
  public void run() {
    try {
      System.out.println("MyRunnable started");
      Thread.sleep(1000);
      System.out.println("MyRunnable end");
    } catch (InterruptedException e) {

    }
  }
}