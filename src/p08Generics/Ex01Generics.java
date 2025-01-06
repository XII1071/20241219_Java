package p08Generics;

public class Ex01Generics {
  public static void main(String[] args) {
    // 장점: 형변환 생략, 타입의 안정성을 도모
    String[] avengers = {"Thor", "CapA", "Hulk", "Iron"};
    Generic<String> generic = new Generic<>();
    generic.set(avengers);
    generic.print();

    Integer[] nums = {0, 1, 2, 3, 4};
    Generic<Integer> generic1 = new Generic<>();
    generic1.set(nums);
    generic1.print();
  }
}

class Generic<T> {
  T[] arr;

  void set(T[] arr) {
    this.arr = arr;
  }

  void print() {
    for (int i = 0; i < arr.length; i++) {
      if (i != 0) System.out.print(", ");
      System.out.print(arr[i]);
    }
    System.out.println();
  }
}