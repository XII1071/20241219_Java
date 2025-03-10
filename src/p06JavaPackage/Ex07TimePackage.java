package p06JavaPackage;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Ex07TimePackage {
  public static void main(String[] args) {
    // java 8 추가, immutable
    // 요일은 월~일 (1~7)
    // 월은 1~12

    LocalDate ld = LocalDate.now();
    System.out.println(ld.hashCode());
    System.out.println(ld);
    System.out.println(ld.hashCode());
    ld.of(2100, 1, 7); //immutable
    System.out.println(ld); //변함이 없다.
    ld = ld.of(2100, 1, 7); // mutable
    System.out.println(ld.hashCode());
    System.out.println(ld);

    LocalTime lt = LocalTime.now();
    System.out.println(lt);
//    lt = lt.of(10, 10, 10);
    System.out.println(lt);

    LocalDateTime ldt = LocalDateTime.now();
    System.out.println(ldt);
    ldt = ldt.of(LocalDate.now(), lt);
    System.out.println(ldt);

    System.out.println("\n2. 특정 필드 값 가져오기 get(), getXXX() ===");
    ld = ld.of(2023, 7, 24);
    ld = ld.now();
    System.out.println(ld);
    System.out.println(ld.getYear());
    System.out.println(ld.getMonth()); // Jan
    System.out.println(ld.getMonthValue()); //1
    System.out.println(ld.getDayOfMonth()); //7
    System.out.println(ld.getDayOfYear()); //7
    System.out.println(ld.lengthOfMonth()); // 31
    System.out.println(ld.lengthOfYear()); // 365
    System.out.println(ld.isLeapYear()); // 윤년인지 확인
    System.out.println(ld.getDayOfWeek()); // TUESDAY
    System.out.println(ld.getDayOfWeek().getValue()); // 2
    System.out.println(ld.get(ChronoField.DAY_OF_WEEK));// 1 월요일~일요일까지 1~7의 값
    System.out.println(ld.get(ChronoField.YEAR_OF_ERA));// 2023
    System.out.println(ld.get(ChronoField.DAY_OF_YEAR));
    System.out.println(lt);
    System.out.println(lt.get(ChronoField.AMPM_OF_DAY)); //오전:0, 오후:1
    System.out.println(lt.get(ChronoField.HOUR_OF_DAY)); //24
    System.out.println(lt.get(ChronoField.HOUR_OF_AMPM)); //0~11
    System.out.println(lt.get(ChronoField.CLOCK_HOUR_OF_AMPM)); //1~12
    System.out.println(lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond());

    System.out.println("\n3. 특정 필드 변경 with(),plus(),plusXXX(),minus(),minusXXX() ===");
    System.out.println("지정 날짜: "+ld);
    System.out.println("DAY_OF_WEEK: " + ld.with(ChronoField.DAY_OF_WEEK,3));
    System.out.println("지정 날짜: "+ld);
    //ALIGNED_WEEK_OF_MONTH 지정요일이 화요일이고 5번째
    System.out.println(ld.with(ChronoField.ALIGNED_WEEK_OF_MONTH, 4));
    System.out.println("달의 첫째날: " + ld.withDayOfMonth(1));
    System.out.println("달의 마지막 날: " + ld.withDayOfMonth(ld.lengthOfMonth()));
    System.out.println("달의 첫째날: " + ld.with(TemporalAdjusters.firstDayOfMonth()));
    System.out.println("달의 마지막 날: " + ld.with(TemporalAdjusters.lastDayOfMonth()));
    YearMonth ym = YearMonth.of(2023, 2);
    System.out.println("달의 첫째날: " + ym.atDay(1));
    System.out.println("달의 마지막 날: " + ym.atEndOfMonth());

    System.out.println(ld.plus(1, ChronoUnit.YEARS));
    System.out.println(ld.plusYears(1));
    System.out.println(ld.plusDays(1));
    System.out.println(ld.minusYears(1));
    ld = ld.of(2025, 3, 1);
    System.out.println(ld.minusDays(1));
    //plusHours, plusMinutes, plusSeconds

    System.out.println("\n4. 날짜와 시간의 비교 isEqual(), isAfter(), isBefore() ===");
    ld = ld.with(LocalDate.now());
    //with() 메서드는 현재 날짜를 기준으로 상대적인 날짜를 리턴
    System.out.println("현재 날짜: "+ld);
    LocalDate ld2 = LocalDate.of(2025, 1, 7);
    System.out.println(ld.equals(ld2)); //false
    System.out.println(ld.isEqual(ld2)); //false 단순 날짜비교
    System.out.println(ld.isAfter(ld2)); //false
    System.out.println(ld.isBefore(ld2)); //true

    JapaneseDate jdt = JapaneseDate.from(LocalDate.now());
    System.out.println(jdt);
    System.out.println(ld.equals(jdt)); //false 연대가 다름.
    System.out.println(ld.isEqual(jdt)); // true 오직 날짜만 비교

    // java.util.Date => LocalDate
    LocalDate ld5 =
        new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    // java.util.Date => LocalDateTime
    LocalDateTime ldt5 =
        new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

    //LocalDate => java.util.Date
    Date d1 = java.sql.Date.valueOf(ld);

    //LocalDateTime => java.util.Date
    Date d2 = java.sql.Timestamp.valueOf(ldt);

    //java.sql.Date => java.util.Date
    Date d3 = new java.sql.Date(new Date().getTime());

    SimpleDateFormat sdf =
        new SimpleDateFormat("yyyy-MM-dd E a hh:mm:ss");
    System.out.println(sdf.format(
        new Date()));
    System.out.println(sdf.format(
        java.sql.Date.valueOf(LocalDate.now())));//날짜만!

    System.out.println(LocalDateTime.now());
    System.out.println(sdf.format(
        java.sql.Timestamp.valueOf(LocalDateTime.now())));

  }
}
