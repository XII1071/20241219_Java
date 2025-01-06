package p07Collection;

import java.util.HashSet;
import java.util.Set;

public class Ex05Set {
  public static void main(String[] args) {
    Set set = new HashSet();
//    set.add(1);set.add(1);set.add(1);set.add(1);
//    System.out.println(set);
    set.add(new Student("홍길동", 1));
    set.add(new Student("김길동", 2));
    set.add(new Student("이길동", 3));
    //System.out.println(set);
    // 원소에 접근하려고 할 때
    for (Object item : set) {
      Student s = (Student) item;
      System.out.print(s.getName());
    }

    // generics 사용하면 타입으로 바로 적용 가능
    // 형변환의 수고를 덜고, 타입의 안정성을 기함.
    Set<Student> set1 = new HashSet<>();
    set1.add(new Student("홍길동", 1));
    set1.add(new Student("김길동", 2));
    set1.add(new Student("이길동", 3));
    for (Student s : set1) {
      System.out.println(s.getName());
    }

    Set<Integer> lotto = new HashSet<>();
//    while (lotto.size() < 6) {
    for (; lotto.size() < 6; ) {
      lotto.add((int) (Math.random() * 45) + 1);
    }
    System.out.println(lotto);
  }
}

class Student {
  private String name;
  private int no, kor, eng, math;

  public Student(String name, int no) {
    this.name = name;
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    this.kor = kor;
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }
}