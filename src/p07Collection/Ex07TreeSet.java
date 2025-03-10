package p07Collection;

import java.util.Set;
import java.util.TreeSet;

public class Ex07TreeSet {
  public static void main(String[] args) {
    Set set = new TreeSet();
    set.add(5);set.add(3);set.add(1);set.add(2);set.add(4);
    System.out.println(set);
    String[] colors = {"yellow", "Red", "black", "Pink", "blue", "orange"};
    Set<Ball> lotto = new TreeSet<>();
    while (lotto.size() < 6) {
      lotto.add(
          new Ball((int) (Math.random() * 45) + 1,
              colors[lotto.size()]
          ));
    }
    System.out.println(lotto);
  }

}
class Ball implements Comparable{
  private int num;
  private String color;
  public Ball(int num, String color) {
    this.num = num;this.color=color;
  }
  public int getNum() {return num;}
  public void setNum(int num) {this.num = num;}
  @Override
  public String toString() {return color+num;}
  @Override
  public int compareTo(Object o) {
    Ball ball = (Ball) o;
    //return num - ball.getNum(); //기본형이라서 빼기 적용
    return color.toLowerCase().compareTo(ball.color.toLowerCase());
  }
}

