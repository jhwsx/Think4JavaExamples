package reusing._09;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class Stem extends Root {

    Component1 c1stem = new Component1();
    Component2 c2stem = new Component2();
    Component3 c3stem = new Component3();

    Stem() {
        System.out.println("Stem constructor");
    }

    public static void main(String[] args) {
        Stem stem = new Stem();
    }
}

class Root {
    Component1 c1root = new Component1();
    Component2 c2root = new Component2();
    Component3 c3root = new Component3();
    Root() {
        System.out.println("Root constructor");
    }
}

class Component1 {
    Component1() {
        System.out.println("Component1 constructor");
    }
}

class Component2 {
    Component2() {
        System.out.println("Component2 constructor");
    }
}

class Component3 {
    Component3() {
        System.out.println("Component3 constructor");
    }
}
