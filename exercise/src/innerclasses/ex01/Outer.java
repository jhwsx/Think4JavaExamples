package innerclasses.ex01;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Outer {
    class Inner {
       Inner() {
           System.out.println("Inner()");
       }
    }
    Outer() {
        System.out.println("Outer()");
    }
    Inner makeInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Inner inner = new Outer().new Inner();
        System.out.println("------------");
        Outer outer = new Outer();
        Inner inner1 = outer.makeInner();
    }
}
