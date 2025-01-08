package p09Stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Ex04Stream {
  public static void main(String[] args) {
    Stream<Student> stream = Stream.of(
        new Student("감자바", 3, 300),
        new Student("이자바", 3, 200),
        new Student("박자바", 2, 200),
        new Student("정자바", 2, 200),
        new Student("최자바", 1, 200),
        new Student("안자바", 1, 200),
        new Student("전자바", 3, 200),
        new Student("강자바", 1, 200),
        new Student("약자바", 2, 100)
    );
    // 1. 반별 정리
    /*stream.sorted(
        Comparator
        .comparing(new Function<Student, Integer>() {
          @Override
          public Integer apply(Student student) {
            return student.getBan(); // 반별로 정렬
          }
        })
        .thenComparing(Comparator.naturalOrder())
        .thenComparing(new Comparator<Student>() {
          @Override
          public int compare(Student o1, Student o2) {
//            return o1.getName().compareTo(o2.getName());
            return (o1.getTotal() - o2.getTotal());
          }
        }))
        .forEach(new Consumer<Student>() {
          @Override
          public void accept(Student student) {
            System.out.println(student);
          }
        });
        */
    Optional<Student> student = stream.reduce(
        new BinaryOperator<Student>() {
          @Override
          public Student apply(Student s1, Student s2) {
            return s1.getTotal() > s2.getTotal() ? s1 : s2;
          }
        }
    );
    System.out.println(student);

  }
}

class Student implements Comparable<Student> {
  String name;
  int ban;
  int total;

  public Student(String name, int ban, int total) {
    this.name = name;
    this.ban = ban;
    this.total = total;
  }

  @Override
  public int compareTo(Student s) {
    return -1 * (total - s.total);
  }

  @Override
  public String toString() {
    return String.format("[%s, %d, %d]", name, ban, total);
  }

  public String getName() {
    return name;
  }

  public int getBan() {
    return ban;
  }

  public int getTotal() {
    return total;
  }
}