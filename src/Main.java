// class 밖으로 변수와 메서드를 선언할 수 절대 없다.
//int tot = 10;
//void eat(){}

import p04class.Ex11Modifier;

class Foo {
    String name;

//자동 정렬 : ctrl + alt + l
    void sleep() {
        for (int i = 0; i < 2; i++) {
            System.out.println(name + " 쿨쿨~");
        }
    }
    // main()는 같은 파일에서는 하나만 존재해야 한다.
//    public static void main(String[] args) {
//        Foo foo = new Foo();
//        foo.name = "곰돌이";
//        foo.sleep();
//    }
}

// public 붙은 클래스는 반드시 파일명과 일치! 단 하나의 class에만 붙일 수 있음.
public class Main {
    public static void main(String[] args) {
        Ex11Modifier ex = new Ex11Modifier();
        ex.publicVar = 100;
        ex.publicMethod();

    }
}
class ExTemp extends Ex11Modifier {
    @Override
    protected void protectedMethod() {
        super.protectedMethod();
        System.out.println(protectedVar);
    }

}