package p04class;

public class Ex05Casting목적 {
  public static void main(String[] args) {
    Buyer buyer = new Buyer();
    Tv tv = new Tv();
    Audio audio = new Audio();
    Computer computer = new Computer();
    buyer.buy(tv);buyer.buy(computer);
    buyer.buy(audio);
  }
}

class Buyer {
  int money = 1500;
//  void buyTv(){ money -= 300; }
//  void buyAudio(){ money -= 500; }
//  void buyComputer(){ money -= 700; }
//  void buy(Tv tv){money -= tv.price;}
//  void buy(Audio audio){money -= audio.price;}
//  void buy(Computer computer){money -= computer.price;}
  void buy(Product product) {
    money -= product.price;
  }
}

class Product {
  int price;
  public Product(int price) {this.price = price;}
}
class Tv extends Product{
  public Tv() {super(300);}
}

class Audio extends Product{
  public Audio() {super(500);}
}

class Computer extends Product{
  public Computer() {super(700);}
}