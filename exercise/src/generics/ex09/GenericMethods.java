package generics.ex09;

import holding.ex31.Shape;
import pets.Pet;

/**
 * 泛型方法
 *
 * @author wangzhichao
 * @since 2019/12/09
 */
public class GenericMethods {
    public <T, S, W> void f(T x, S s, W w) {
        System.out.println(x.getClass().getName()
                + ", " + s.getClass().getName()
                + ", " + w.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", new Pet(), new Shape());
        gm.f(1, 1, 1);
        gm.f(1.0, "x", 'b');
        gm.f(1.0f, 0x11, 1);
        gm.f(gm, false, true);
    }
}
