package generics;

/**
 * @author wangzhichao
 * @since 2020/01/05
 */
interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}

public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        // 编译错误：需要的是 Setter 类型，给我 SelfBoundSetter 干啥？
//        s1.set(sbs);
    }
}
