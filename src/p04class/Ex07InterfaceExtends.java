package p04class;

public class Ex07InterfaceExtends implements ITriathlon {
  @Override
  public void play() {
    ITriathlon.super.play();
  }

  @Override
  public void ride() {
    System.out.println("자전거 타다");
  }

  @Override
  public void run() {
    System.out.println("달리다");
  }

  @Override
  public void swim() {
    System.out.println("수영하다");
  }

  public static void main(String[] args) {
    Ex07InterfaceExtends player = new Ex07InterfaceExtends();
    player.play();
  }
}

interface ISwim {
  void swim();
}

interface IBicycle {
  void ride();
}

interface IMarathon {
  void run();
}

interface ITriathlon extends ISwim, IBicycle, IMarathon {
  public default void play() {
    swim();
    ride();
    run();
  }
}