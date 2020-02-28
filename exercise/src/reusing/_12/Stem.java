package reusing._12;

/**
 * @author wzc
 * @date 2019/7/12
 */
public class Stem extends Root {

    Component1 c1stem = new Component1();
    Component2 c2stem = new Component2();
    Component3 c3stem = new Component3();

    Stem() {
        System.out.println("Stem constructor");
    }

    void dispose() {
        c3stem.dispose();
        c2stem.dispose();
        c1stem.dispose();
        System.out.println("Stem.dispose()");
        super.dispose();
    }

    public static void main(String[] args) {
        Stem stem = new Stem();
        try {
        } finally {
            stem.dispose();
        }
    }
}

class Root {
    Component1 c1root = new Component1();
    Component2 c2root = new Component2();
    Component3 c3root = new Component3();
    Root() {
        System.out.println("Root constructor");
    }

    void dispose() {
        c3root.dispose();
        c2root.dispose();
        c1root.dispose();
        System.out.println("Root.dispose()");
    }
}

class Component1 {
    Component1() {
        System.out.println("Component1 constructor");
    }

    void dispose() {
        System.out.println("Component1.dispose()");
    }
}

class Component2 {
    Component2() {
        System.out.println("Component2 constructor");
    }
    void dispose() {
        System.out.println("Component2.dispose()");
    }
}

class Component3 {
    Component3() {
        System.out.println("Component3 constructor");
    }
    void dispose() {
        System.out.println("Component3.dispose()");
    }
}
