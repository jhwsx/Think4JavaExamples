package innerclasses.ex26;

/**
 * @author wzc
 * @date 2019/7/28
 */
class Outer {
    Outer() {
        System.out.println("Outer()");
    }
    class Inner {
        Inner(int i) {
            System.out.println("Inner("+i+")");
        }
    }
}
public class Ex26 {
    public Ex26() {
        System.out.println("Ex26()");
    }
    class ExInner extends Outer.Inner {

        ExInner(Outer outer,int i) {
            outer.super(i);
            System.out.println("ExInner()");
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Ex26 ex26 = new Ex26();
        ExInner exInner = ex26.new ExInner(outer, 12);
    }
}
