package p04class;

public class Ex04ExtendsCasting {
  public static void main(String[] args) {
    Father f1 = new Father("아빠", 40);
    Son s1 = new Son("아들", 10);
    System.out.println(f1);
    System.out.println(s1);
    System.out.println(s1.name); //생성자의 super때문에 Son의 속성에 초기화 안됨.
    System.out.println(s1.age);

    Father f2 = new Father();
    Son s2 = new Son();
    System.out.println(f2);
    System.out.println(s2);

    // 상속 관계에서 형변환이 발생하면서, 속성이 중복되는 경우
    // 1) 자식 -> 부모 :: OK 묵시적 형변환 가능
    Father f3 = new Son(); //super가 기본이라서 부모에 값을 못 넘겨 주기 때문
    System.out.println(f3);  //toString()::메서드는 자식꺼
    System.out.println(f3.age);//age::멤버변수는 부모꺼
    // 형변환이 일어난 경우 메서드는 자식꺼, 변수는 부모꺼

    // 2) 부모 -> 자식 :: NO
    // Son s3 = new Father();

    // 3) 자식 -> 부모 -> 자식 :: OK 명시적 형변환 필요
    Son s4 = (Son) f3;
  }
}
class Father{
  int age;
  String name;

  // 생성자를 추가하면 JVM이 더이상 기본 생성자는 안만듦.
  public Father(String name, int age){
    this.name=name; this.age=age;
  }
  public Father(){age = 42;}

  @Override
  public String toString() {
    return "Father: "+age + " / " + name;
  }
}
class Son extends Father {
  int age;
  String name;
  public Son(){
    super("아들", 12);//Father의 age에 값을 12로 초기화
    super.age = 12; //Father의 age에 값을 12로 초기화
    age = 12; // Son의 age에 값을 12로 초기화(Father, Son 동시에 age를 가질 경우)
  }

  public Son(String name, int age) {
    super(name, age);
  }

  @Override
  public String toString() {
//    return String.format("Son: %d / %s", super.age, super.name);
    return String.format("Son: %d / %s", age, name);
  }
}