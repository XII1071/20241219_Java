package p04class;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex09FunctionPackage {
  // 일반적으로 자주 쓰이는 메서드 형식 4가지를 @FunctionalInterface 형태로 제작
  // Java 8 버전에서 표준 API 형태의 함수형 인터페이스를 정의
  public static void main(String[] args) {
    // 1. 매개변수 X, 리턴타입 O
    Supplier<Integer> supplier = new Supplier<Integer>() {
      @Override
      public Integer get() {
        return (int) (Math.random() * 100) + 1;
      }
    };
    supplier = () -> {return (int) (Math.random() * 100) + 1;};
    supplier = () -> (int) (Math.random() * 100) + 1;

    // 2. 매개변수 O, 리턴타입 X
    Consumer<Integer> consumer = new Consumer<Integer>() {
      @Override
      public void accept(Integer integer) {
        System.out.println(integer + " ");
      }
    };
    consumer = integer -> {System.out.print(integer + " ");};
    consumer = integer -> System.out.print(integer + " ");

    Consumer<Boolean> consumer1 = b -> System.out.print(b + " ");

    // 3. 매개변수 O, 리턴타입 O
    Function<Integer, Integer> function = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer i) {
        return i * 10;
      }
    };
    function = i -> i * 10;

    Function<Integer, Boolean> function1 = new Function<Integer, Boolean>() {
      @Override
      public Boolean apply(Integer i) {
        return i%2==0?true:false;
      }
    };

    // 4. 매개변수 O, 리턴타입 O(boolean)
    Predicate<Integer> predicate = new Predicate<Integer>() {
      @Override
      public boolean test(Integer integer) {
        return integer % 2 == 0;
      }
    };
    predicate = i -> i%2 == 0;

    // 응용
    List<Integer> list = new ArrayList<>();

    makeRandomList(list, supplier);
    printList(list, consumer);
    printEven(list, consumer, predicate);
    printList(doSomething(list, function1), consumer1);
    printList(doSomething(list, function), consumer);
  }
  // 메서드 리턴타입 앞의 <T>는 매개변수의 T를 결정
  static <T> void makeRandomList(List<T> list, Supplier<T> supplier) {
    for (int i = 0; i < 10; i++) {
      list.add(supplier.get());
    }
  }

  private static <T> void printList(List<T> list, Consumer<T> consumer) {
    for (int i = 0; i < list.size(); i++) {
      consumer.accept(list.get(i));
    }
    System.out.println();
  }

  private static <T> void printEven(List<T> list, Consumer<T> consumer, Predicate<T> predicate) {
    for (T i : list) if(predicate.test(i)) consumer.accept(i);
    System.out.println();
  }

  private static<T, R> List<R> doSomething(List<T> list, Function<T, R> function) {
    List<R> tempList = new ArrayList<>(list.size());
    for (T item : list) tempList.add(function.apply(item));
    return tempList;
  }
}
