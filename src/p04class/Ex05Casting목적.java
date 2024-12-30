package p04class;

public class Ex05Casting목적 {
  public static void main(String[] args) {
    Buyer buyer = new Buyer();
    Tv tv = new Tv();
    Audio audio = new Audio();
    Pc pc = new Pc();
    buyer.buy(tv);
    buyer.buy(audio);
    buyer.buy(pc);
  }
}

class Buyer {
  int money = 1500;
  //  void buyTv() {money -= 300;}
  //  void buyAudio() {money -= 300;}
  //  void buyPc() {money -= 700;}

  //  void buy(Tv tv) {money -= tv.price;}
  //  void buy(Audio audio) {money -= audio.price;}
  //  void buy(Pc pc) {money -= pc.price;}

  void buy(Product product) {
    money -= product.price;
  }


}

class Product {
  int price;

  public Product(int price) {
    this.price = price;
  }
}

class Tv extends Product {
  public Tv() {
    super(300);
  }
}

class Audio extends Product {
  public Audio() {
    super(500);
  }
}

class Pc extends Product {
  public Pc() {
    super(700);
  }
}

