package innerclasses.ex23;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex23 {
    public static void main(String[] args) {
        A a0 = new A();
        A a1 = new A();
        A a2 = new A();
        B b = new B(3);
        b.add(a0.makeU(), 0);
        b.add(a1.makeU(), 1);
        b.add(a2.makeU(), 2);
        b.show();
        b.testUs();
        b.eraseU(0);
        b.eraseU(1);
        b.show();
    }
}
