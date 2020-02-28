package innerclasses.ex18;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Outer {
    public Outer() {
        System.out.println("Outer()");
    }

    static class Nest {
        public Nest() {
            System.out.println("Nest()");
        }
    }

    public static void main(String[] args) {
        // 不会创建外部类的对象，因为二者没有对象之间的联系。
        Nest nest = new Nest();
    }
}
