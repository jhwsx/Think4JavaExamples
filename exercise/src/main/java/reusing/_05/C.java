package reusing._05;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class C extends A {
    B b = new B();

    public static void main(String[] args) {
        C c = new C();
    }
}

class A {
    A() {
        System.out.println("A() constructor");
    }
}

class B {
    B() {
        System.out.println("B() constructor");
    }
}
