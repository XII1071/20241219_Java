package p04class;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ex09MethodReference {
  public static void main(String[] args) {
    // 메소드 레퍼런스는 ClassName::MethodName 형식
    // 메소드를 호출하는 것이지만 괄호()는 써주지 않고 생략
    // 모든 코드를 다 써주는 것이 번거로울 때 최대한 생략함.
    // static, instance, constructor 메서드 레퍼런스

    // 1. 익명객체
    Consumer<String> func = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    };
    // 2. 람다식
    func = s -> System.out.println(s);
    // 3. 메서드레퍼런스
    func = System.out::println;

    // 1. 익명 객체로 선언
    Executable ex1 = new Executable() {
      @Override
      public void doSomething(String text) {
        Printer.printSomething(text);
      }
    };
    // 2. 람다식으로 전환
    ex1 = text -> Printer.printSomething(text);
    // 2. 메서드레퍼런스로 전환
    ex1 = Printer::printSomething;
    ex1.doSomething("Hello World");

    // 3. :: method reference
    // 조건: printSomething이 인자 1를 받아서 처리하는 static메서드
    Executable ex2 = Printer::printSomething;
    ex2.doSomething("Hello World");

    List<String> companies=Arrays.asList("google", "apple", "samsung");
    companies.stream().forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.print(s+" ");
      }
    });
    System.out.println();
    companies.stream().forEach(s -> System.out.print(s+" "));
    System.out.println();
    companies.stream().forEach(System.out::print);
    System.out.println();
    companies.stream().map(new Function<String, Company>() {
      @Override
      public Company apply(String s) {
        return new Company(s);
      }
    }).forEach(new Consumer<Company>() {
      @Override
      public void accept(Company c) {
        c.printName();
      }
    });
    companies.stream()
        .map(s -> new Company(s))
        .forEach(c->c.printName());
  }
  interface Executable {
    void doSomething(String text);
  }

  public static class Printer {
    static void printSomething(String text) {
      System.out.println(text);
    }
  }

  public static class Company {
    String name;
    public Company(String name) {this.name = name;}
    public void printName(){System.out.print(name+" ");}
  }
}

