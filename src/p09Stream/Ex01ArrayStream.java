package p09Stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Ex01ArrayStream {
  // since Java8, 배열 및 컬렉션을 다루기 위함.
  // 대량의 데이터(컬렉션, 배열)를 스트림으로 변환해서
  // Elements(원소)를 일일히 다루지 않고
  // 처리해야 할 내용을 함수형 인터페이스로 정의만 해주면
  // 내부적으로 반복을 통해서 결과를 생성
  // 기술적으로는 Fork와 Join을 활용
  // 배열은 Arrays.stream()으로 스트림생성하고
  // 컬렉션은 자체적으로 스트림 처리 가능
  // 스트림을 다루는 메서드는 forEach(), map(),flatMap(),
  // distinct(), sorted(), removeIf(), removeAll() ..
  public static void main(String[] args) {
    String[] arr = {"abc", "def", "ghi"};
    Stream<String> stringStream = Arrays.stream(arr);
    stringStream.forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.print(s + " ");
      }
    });
    System.out.println();
    stringStream = Arrays.stream(arr);
    stringStream.forEach(s -> System.out.print(s + " "));
//    stringStream.forEach(System.out::print);
    System.out.println();

    String[] arr2 = {"ABC", "DEF", "GHI"};
    Stream<String[]> arrStream = Stream.of(arr, arr2);
    Stream<String> strStream = arrStream.flatMap(
        new Function<String[], Stream<? extends String>>() {
          @Override
          public Stream<? extends String> apply(String[] strings) {
            return Arrays.stream(strings);
          }
        }
    );
    // strStream.forEach(s -> System.out.printf(s + " "));
    System.out.println();

    strStream.map(new Function<String, String>() {
      @Override
      public String apply(String s) {
        return s.toLowerCase();
      }
    }).distinct().sorted().forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    });

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {

      // 지역변수가 익명객체안으로 상수로 변환해서 드감.
      final int tmp = i;
      list.add(new Supplier<Integer>(){
        @Override
        public Integer get() {
          return tmp;
        }
      }.get());

//      list.add((new Function<Integer, Integer>() {
//        @Override
//        public Integer apply(Integer integer) {
//          return integer;
//        }
//      }).apply(i));

    }
    System.out.println(">> "+list);
    list.removeIf(i -> i % 2 == 0);
    System.out.println(">> "+list);
    list.replaceAll(new UnaryOperator<Integer>() {
      @Override
      public Integer apply(Integer i) {
        return i * i;
      }
    });
    System.out.println(">> "+list);



    Map<String, String> map = new HashMap<>();
    map.put("a", "1");map.put("b", "2");map.put("c", "3");
    map.forEach(new BiConsumer<String, String>() {
      @Override
      public void accept(String s, String s2) {
        System.out.printf("%s : %s \n", s, s2);
      }
    });
    map.forEach((s, s2) -> System.out.printf("%s : %s \n", s, s2));

    List<String> list2 = new ArrayList<>();
    list2.add("손흥민");list2.add("황희찬");list2.add("황인범");
    list2.add("김민재");
    // list가 자체 스트림처리 가능, 성능 극대화 위해 parallelStream()으로
    // Fork와 Join을 통해 분할정복(Divide and Conquer)기법
    Stream<String> nameStream = list2.parallelStream();
    nameStream.forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
        System.out.println(s.toLowerCase());
      }
    });
  }
}
