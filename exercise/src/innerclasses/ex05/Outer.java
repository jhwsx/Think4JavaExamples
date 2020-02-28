package innerclasses.ex05;

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
        Inner() {
            System.out.println("Inner()");
        }
    }

    public Outer() {
        System.out.println("Outer()");
    }
}
