package innerclasses.ex08;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Outer {
    class Inner {
        private int value = 11;
        private void f() {
            System.out.println("Inner.f()");
        }
    }

    Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.inner();
        System.out.println(inner.value);
        inner.f();
    }
}
