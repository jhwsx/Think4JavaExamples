package generics.ex03;

import net.mindview.util.FiveTuple;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
    public final F sixth;

    public SixTuple(A a, B b, C c, D d, E e, F sixth) {
        super(a, b, c, d, e);
        this.sixth = sixth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " +
                third + ", " + fourth + ", " +
                fifth + ", " + sixth + ")";
    }
}
