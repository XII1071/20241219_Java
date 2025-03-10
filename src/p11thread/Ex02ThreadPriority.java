package p11thread;

public class Ex02ThreadPriority {
  public static void main(String[] args) {
    Thread t1 = new Thread() {
      @Override
      public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("t1 thread started");
        for (int i = 0; i < 300; i++) {
          System.out.printf("+");
        }
        System.out.println("t1 걸린 시간: " + (
            System.currentTimeMillis() - startTime));
      }
    };
    Thread t2 = new Thread() {
      @Override
      public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("t2 thread started");
        for (int i = 0; i < 300; i++) {
          System.out.printf("-");
        }
        System.out.println("t2 걸린 시간: " + (
            System.currentTimeMillis() - startTime));
      }
    };

    // 우선순위 지정
    // 스레드의 우선순위 기본값: 5, 범위는 1~10
    // 운영체제에 따라서 운선순위가 7까지인 경우도 존재,7이상은 주의
    // 우선순위의 숫자가 높을 수록 우선순위가 높다.
    t1.setPriority(7); t2.setPriority(3);
    t1.start();t2.start();

  }
}
