package generics;

/**
 * 移除了自限定
 * @author wangzhichao
 * @since 2020/01/05
 */
public class NotSelfBounded<T /*extends NotSelfBounded<T>*/> {
    T element;

    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A2 extends NotSelfBounded<A2> {}

class B2 extends NotSelfBounded<A2> {}

class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 arg) {
        set(arg);
        return get();
    }
}

class D2 {}
// 这里编译通过了
class E2 extends NotSelfBounded<D2> {}
