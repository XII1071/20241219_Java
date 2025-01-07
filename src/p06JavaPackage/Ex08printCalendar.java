package p06JavaPackage;

import java.util.Calendar;
import java.util.Scanner;

public class Ex08printCalendar {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("::: 달력 출력 :::");
    System.out.println("(종료는 Q,q)");
    System.out.print("연도와 월을 입력(ex 2025 1):");
    String input = scan.nextLine();
    if (input.equalsIgnoreCase("q")) {
      System.out.println("프로그램을 종료합니다.");
      System.exit(-1);
    }
    String[] arr = input.trim().split(" ");
    if (arr.length != 2) {
      System.out.println("프로그램을 종료합니다.");
      System.exit(-1);
    }
    int year = Integer.parseInt(arr[0]);
    int month = Integer.parseInt(arr[1]);

    Calendar start = Calendar.getInstance();
    Calendar end = Calendar.getInstance();
    start.set(year, month - 1, 1);
    end.set(year, month, 1);
    end.add(Calendar.DATE, -1);
    final int weekDay = start.get(Calendar.DAY_OF_WEEK);
    int cnt = 0;

    System.out.println(String.format("==== %d - %d ====", year, month));
    System.out.println(" SU MO TU WE TH FR SA");
    for (int i = 0; i < weekDay - 1; i++) {
      System.out.printf("%s", "   "); // 1일 앞에 공백 출력(3칸)
      cnt++; // 다음 줄 내려가기 위한 증가 값
    }
    for (int i = 0; i < end.get(Calendar.DATE); i++) {
      if (cnt++ % 7 == 0) {
        System.out.println();
      }
      System.out.printf("%3d", i + 1);
    }

  }
}