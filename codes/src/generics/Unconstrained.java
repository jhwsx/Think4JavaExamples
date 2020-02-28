package generics;

/**
 * @author wangzhichao
 * @since 2020/01/05
 */
class Other {
}
// BasicHolder 使用 Other 作为其泛型参数，而不是使用 BasicOther。
class BasicOther extends BasicHolder<Other> {
}

public class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther();
        BasicOther b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f(); // 打印：Other
    }
}
