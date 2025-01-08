package p09Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex04Stream {
  public static void main(String[] args) {
    Student[] students = {
        new Student("핫바", 3, 300),
        new Student("이자바", 3, 200),
        new Student("박자바", 2, 200),
        new Student("정자바", 2, 200),
        new Student("최자바", 1, 200),
        new Student("안자바", 1, 200),
        new Student("전자바", 3, 200),
        new Student("강자바", 1, 200),
        new Student("약자바", 2, 100)
    };
    Stream<Student> stream = Stream.of(students);
    // 1. 반별 정리
    stream.sorted(
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

    // 2. totoal 최고점수 출력 Optional :: only one
    stream = Stream.of(students);
    Optional<Student> student = stream.reduce(
        new BinaryOperator<Student>() {
          @Override
          public Student apply(Student s1, Student s2) {
            return s1.getTotal() > s2.getTotal() ? s1 : s2;
          }
        }
    );
    System.out.println(student);

    // 3. stream 목록 출력
    stream = Stream.of(students);
    stream.forEach(s -> System.out.println(s));

    // 4. stream을 배열로 변환
    Student[] sArr = Stream.of(students).toArray(
        new IntFunction<Student[]>() {
          @Override
          public Student[] apply(int value) {
            return new Student[value];
          }
        });
    System.out.println(Arrays.toString(sArr));

    // 5. student 전체 인원수 구하기
    System.out.println(Stream.of(students).count());
    System.out.println(Stream.of(students).collect(
        Collectors.counting()
    ));

    // 6. student 총 합계 구하기
    int result = Stream.of(students).collect(
        Collectors.summingInt(new ToIntFunction<Student>() {
          @Override
          public int applyAsInt(Student s) {
            return s.getTotal();
          }
        })
    );
    System.out.println("총 합계: " + result);

    // 7. 최고 합 인원 구하기
    System.out.println(Stream.of(students).collect(
        Collectors.maxBy(
            Comparator.comparingInt(new ToIntFunction<Student>() {
              @Override
              public int applyAsInt(Student s) {
                return s.getTotal();
              }
            })
        )));
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