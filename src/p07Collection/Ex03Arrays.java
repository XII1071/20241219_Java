package p07Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

// Arrays :: Collection에서 배열을 다루기 위해 추가.
public class Ex03Arrays {
  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3, 4};
    int[] arr2 = Arrays.copyOf(arr, arr.length);
    int[] arr3 = Arrays.copyOfRange(arr, 2, 4);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arr2));
    System.out.println(Arrays.toString(arr3));
    int[] arr4 = new int[5];
    Arrays.fill(arr4, 10);
    System.out.println(Arrays.toString(arr4));
    Arrays.setAll(arr4, new IntUnaryOperator() {
      @Override
      public int applyAsInt(int operand) {
        return (int) (Math.random() * 5);
      }
    });
    Arrays.setAll(arr4, operand -> (int) (Math.random() * 5));
    System.out.println(Arrays.toString(arr4));
    Arrays.sort(arr4);
    System.out.println(Arrays.toString(arr4));

    // 배열을 list로 변환
    Integer[] arrInt1 = new Integer[]{0, 1, 2, 3};
    List<Integer> intList = new ArrayList(Arrays.asList(arrInt1)); //Collection으로 ArrayList 생성
    System.out.println(intList);

    // list를 배열로 변환
    Integer[] arrInt2 = (Integer[]) intList.toArray(new Integer[intList.size()]); //크기를 잡음
    System.out.println(Arrays.toString(arrInt2));

    // 주소를 잡음, 배열을 가리키는 참조변수는 null 대신 길이가 0인 배열로 초기화
    // 리스트를 배열로 변환하기 위해 배열을 단순히 참조함. 그래서 0
    Integer[] arrInt3 = (Integer[]) intList.toArray(new Integer[0]);
    System.out.println(Arrays.toString(arrInt3));

    Integer[] arrInt4 = (Integer[]) intList.stream().toArray(new IntFunction() {
      @Override
      public Object apply(int value) {
        return new Integer[value];
      }
    });
    Integer[] arrInt5 = intList.stream().toArray(value -> new Integer[value]);
    System.out.println(">>" + Arrays.toString(arrInt5));
  }

}