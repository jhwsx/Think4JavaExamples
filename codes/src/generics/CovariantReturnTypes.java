package generics;

/**
 * @author wangzhichao
 * @since 2020/01/05
 */
class Base {}
class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    // 重写方法的返回类型是允许变化的
    @Override
    Derived get();
}
public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }
}
