package reusing._10;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class Stem extends Root {

    Component1 c1stem = new Component1((byte) 4);
    Component2 c2stem = new Component2((short) 5);
    Component3 c3stem = new Component3(6);

    Stem(boolean b) {
        super(b);
        System.out.println("Stem constructor");
    }

    public static void main(String[] args) {
        Stem stem = new Stem(false);
    }
}

class Root {
    Component1 c1root = new Component1((byte) 1);
    Component2 c2root = new Component2((short) 2);
    Component3 c3root = new Component3(3);
    Root(boolean b) {
        System.out.println("Root constructor");
    }
}

class Component1 {
    Component1(byte b) {
        System.out.println("Component1 constructor byte");
    }
}

class Component2 {
    Component2(short s) {
        System.out.println("Component2 constructor short");
    }
}

class Component3 {
    Component3(long s) {
        System.out.println("Component3 constructor long");
    }
}
