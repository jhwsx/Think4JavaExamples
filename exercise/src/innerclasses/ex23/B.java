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
public class B {
    U[] us;

    public B(int length) {
        us = new U[length];
    }
    public void add(U u, int i) {
        us[i] = u;
    }

    public void eraseU(int i) {
        us[i] = null;
    }

    public void testUs() {
        for (U u : us) {
            if (u == null) {
                continue;
            }
            u.f();
            u.g();
            u.toString();
        }
    }

    public void show() {
        for (U u : us) {
            if (u != null) {
                System.out.println(u);
            } else {
                System.out.println("null");
            }
        }
    }
}
