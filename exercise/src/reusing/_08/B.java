package reusing._08;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class B extends A {
    B() {
        super(1);
    }
    B(int i) {
        super(2);
    }

}

class A {
    A(int i) {
        System.out.println("A constructor");
    }
}
