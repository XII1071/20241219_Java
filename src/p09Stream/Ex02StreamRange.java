package p09Stream;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ex02StreamRange {
  public static void main(String[] args) {
    IntStream intStream = new Random().ints(1, 5);
    intStream.limit(5).forEach(i -> System.out.println(i));

    LongStream longStream = LongStream.range(1, 46);
    longStream.forEach(i -> System.out.print(i+","));

    IntStream intStream1 = IntStream.rangeClosed(1, 45);
    intStream1.forEach(i -> System.out.print(i+","));

    Stream<Integer> intStream2 = Stream.iterate(0, new UnaryOperator<Integer>() {
      @Override
      public Integer apply(Integer n) {
        return n + 2; // 2씩 누적되어서 증가
      }
    });
    intStream2.limit(5).forEach(i -> System.out.println(i));

    IntStream lottoStream = new Random().ints(1, 46);
    lottoStream.distinct().limit(6).forEach(i -> System.out.println(i));
  }
}
