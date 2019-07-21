package reusing._07;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class C extends A {
    B b = new B(2);

    C() {
        super(1);
    }

    public static void main(String[] args) {
        C c = new C();
    }
}

class A {
    A(int i) {
        System.out.println("A("+i+") constructor");
    }
}

class B {
    B(int i) {
        System.out.println("B("+i+") constructor");
    }
}
