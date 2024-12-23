package p03Array;

public class Ex03Array2D {
  public static void main(String[] args) {
    int[][] arr = new int[3][3];
    arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    print2d(arr);

    int[][] arr2 = new int[4][4];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr2[i][j] = arr[i][j];
        arr2[i][arr.length] += arr[i][j];
        arr2[arr.length][j] += arr[i][j];
      }
    }
    print2d(arr2);
  }

  static void print2d(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(String.format("%3d", arr[i][j]));
      }
      System.out.println();
    }
  }
}
