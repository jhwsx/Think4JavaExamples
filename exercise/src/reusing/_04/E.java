package reusing._04;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class E extends D {
    E() {
        System.out.println("E()");
    }

    public static void main(String[] args) {
        E e = new E();
        System.out.println("Test D");
        D.main(args);
    }
}

class A {
    A() {
        System.out.println("A()");
    }
}

class B extends A {
    B() {
        System.out.println("B()");
    }
}

class C extends B {
    C() {
        System.out.println("C()");
    }
}

class D extends C {
    D() {
        System.out.println("D()");
    }

    public static D makeD() {
        return new D();
    }

    public static void main(String[] args) {
        System.out.println("new D()");
        D d = new D();
        System.out.println("makeD()");
        D d2 = makeD();
    }
}
