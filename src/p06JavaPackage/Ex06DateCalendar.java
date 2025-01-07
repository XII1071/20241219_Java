package p06JavaPackage;

import java.util.Calendar;
import java.util.Date;
import java.util.StringJoiner;

public class Ex06DateCalendar {
  public static void main(String[] args) {
    Date d1 = new Date();
    System.out.println(d1);
    System.out.println(d1.getYear() + 1900);
    System.out.println("getDate(): " + getDate(d1));
    System.out.println("getTime(): " + getTime(d1));
    StringJoiner sj = new StringJoiner(" ", "", "");
    sj.add(getDate(d1));
    sj.add(getTime(d1));
    System.out.println(sj.toString());
    System.out.println(getDate(d1) + " " + getTime(d1));

    Calendar c = Calendar.getInstance();
    System.out.println(c.get(Calendar.YEAR));
    System.out.println(c.get(Calendar.MONTH));
    System.out.println(c.get(Calendar.DATE));
    String[] weeks = ",일,월,화,수,목,금,토".split(",");
    System.out.println(weeks[c.get(Calendar.DAY_OF_WEEK)]);
    System.out.println(c.get(Calendar.HOUR)); //12시간제
    System.out.println(c.get(Calendar.HOUR_OF_DAY));//24시간제
    c.set(2024, 11, 1); //날짜 지정 가능.

    // Date => Calendar
    Date d = new Date();
    Calendar c1 = Calendar.getInstance();
    c1.setTime(d);

    // Calendar => Date
    Date d2 = new Date(Calendar.getInstance().getTimeInMillis());

  }

  static String getDate(Date date) {
    // yyyy-mm-dd
    int month = date.getMonth() + 1;
    int day = date.getDate();
    return date.getYear() + 1900 + "-"
        + (month < 10 ? "0" + month : month) + "-"
        + (day < 10 ? "0" + day : day);
  }

  static String getTime(Date date) {
    // hh:mm:ss
    int h = date.getHours();
    int m = date.getMinutes();
    int s = date.getSeconds();
    return String.format("%s:%s:%s",
        (h < 10 ? "0" + h : h + ""), (m < 10 ? "0" + m : m + ""),
        (s < 10 ? "0" + s : s + ""));
  }
}