package generics.ex10;

import holding.ex31.Shape;
import pets.Pet;

/**
 * @author wangzhichao
 * @since 2019/12/09
 */
public class NonGenericMethods {
    public void f(Object x, Object s, Object w) {
        System.out.println(x.getClass().getName()
                + ", " + s.getClass().getName()
                + ", " + w.getClass().getName());
    }

    public static void main(String[] args) {
        NonGenericMethods gm = new NonGenericMethods();
        gm.f("", new Pet(), new Shape());
        gm.f(1, 1, 1);
        gm.f(1.0, "x", 'b');
        gm.f(1.0f, 0x11, 1);
        gm.f(gm, false, true);
    }
}
