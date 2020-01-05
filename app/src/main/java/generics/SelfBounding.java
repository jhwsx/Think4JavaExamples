package generics;

/**
 * 自限定：强制泛型当作其自己的边界参数来使用。
 * @author wangzhichao
 * @since 2020/01/05
 */
class SelfBounded<T extends SelfBounded<T>> {
    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {}
class B extends SelfBounded<A> {} // 这样也是好的

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {
}

// 编译错误：Type parameter D is not within its bound;
// should extend SelfBounded<D>
//class E extends SelfBounded<D> {
//
//}

// 这样也可以编译通过，说明自限定惯用法不是可强制执行的。
class F extends SelfBounded {}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}
