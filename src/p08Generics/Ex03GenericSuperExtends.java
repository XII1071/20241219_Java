
package p08Generics;

public class Ex03GenericSuperExtends {
  public static void main(String[] args) {
    Gen1 gen1 = new Gen1();
    Gen2 gen2 = new Gen2();
    Gen3 gen3 = new Gen3();

    /*++++++++ <? super type>또는 <? extends type>은 매개변수의 타입을 제약하는데 목적이 있음.
     *<? super Gen2>의 의미는 매개변수의 타입이 Gen2의 조상인 Gen1을 조상으로 할수 있는 타입을 허용(Gen1 포함)
     *super는 ?의 조상을 둔 하위 객체는 모두 포함이 되기 때문에 사실상 제약의 의미가 없다.*/
    GenType<? super Gen2> genType = new GenType<>(gen2);
    Gen3 t3 = (Gen3) genType.get(); //단순한 형변환의 문제
    Gen2 t2 = (Gen2) genType.get(); //단순한 형변환의 문제
    Gen1 t1 = (Gen1) genType.get(); //단순한 형변환의 문제
    Object t4 = genType.get();
//    System.out.println(t3.name);
//    System.out.println(t3.getName());
//    System.out.println(t2.name);
//    System.out.println(t2.getName());
    System.out.println(t1.name);
    System.out.println(t1.getName());

    /*<? extends Gen2>의 의미는 Gen2를 포함한 상속관계에 있는 것들을 허용. Gen1은 매개변수 적용 안됨.*/
    GenType<? extends Gen2> genExtends = new GenType<>(gen3);
    Gen3 e3 = (Gen3) genExtends.get();
    Gen2 e2 = genExtends.get();
    Gen1 e1 = genExtends.get();

    /*? 는 모든 클래스 타입이 가능*/
    GenType<?> genQuestion1 = new GenType<>(gen1);
    GenType<?> genQuestion2 = new GenType<Integer>(1);
  }
}

class Gen1 {
  String name = "Gen1";

  public String getName() {
    return name;
  }
}

class Gen2 extends Gen1 {
  String name = "Gen2";

  public String getName() {
    return name;
  }
}

class Gen3 extends Gen2 {
  String name = "Gen3";

  public String getName() {
    return name;
  }
}

class GenType<T> {
  T obj;

  public GenType(T obj) {
    this.obj = obj;
  }

  public void set(T obj) {
    this.obj = obj;
  }

  public T get() {
    return obj;
  }
}
