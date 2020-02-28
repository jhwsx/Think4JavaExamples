package reusing._23;

/**
 * @author wzc
 * @date 2019/7/13
 */
class A {
    static int j = printInit("A.j initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 1;
    }

    A() {
        System.out.println("A() constructor");
    }
}

class B extends A {
    static int k = printInit("B.k initialized");

    B() {
        System.out.println("B() constructor");
    }
}

class C {
    static int n = printInit("C.n initialized");
    static A a = new A();

    C() {
        System.out.println("C() constructor");
    }

    static int printInit(String s) {
        System.out.println(s);
        return 1;
    }
}

class D {
    D() {
        System.out.println("D() constructor");
    }
}

public class LoadClass extends B {
    static int i = printInit("LoadClass.i initialized");

    LoadClass() {
        System.out.println("LoadClass() constructor");
    }

    public static void main(String[] args) {
        System.out.println("hi");
        LoadClass loadClass = new LoadClass();
        System.out.println(C.a);
        D d = new D();
    }
}
