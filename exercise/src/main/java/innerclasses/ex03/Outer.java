package innerclasses.ex03;

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
    private String s;

    class Inner {
        Inner() {
            System.out.println("Inner()");
        }

        @Override
        public String toString() {
            return s;
        }
    }

    Inner inner() {
        return new Inner();
    }

    Outer(String s) {
        this.s = s;
        System.out.println("Outer(" + s + ")");
    }

    public static void main(String[] args) {
        Outer outer = new Outer("outer_str");
        Inner inner = outer.inner();
        System.out.println(inner);
    }
}
