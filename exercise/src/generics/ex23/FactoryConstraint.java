package generics.ex23;

/**
 * @author wangzhichao
 * @since 2019/12/20
 */
interface FactoryI<T> {
    T create(int y);
}

class Foo2<T> {
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory, int y) {
        x = factory.create(y);
    }
}

class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create(int x) {
        return new Integer(x);
    }
}

class Widget {

    public Widget(int x) {

    }
    public static class Factory implements FactoryI<Widget> {

        @Override
        public Widget create(int x) {
            return new Widget(x);
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory(),2);
        new Foo2<Widget>(new Widget.Factory(),3);
    }
}
