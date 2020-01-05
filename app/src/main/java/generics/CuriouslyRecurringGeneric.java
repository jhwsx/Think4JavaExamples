package generics;

/**
 * @author wangzhichao
 * @since 2020/01/05
 */
class GenericType<T> {
}

/**
 * 该类继承自一个泛型类型，这个泛型类型接收该类的名称作为其参数
 */
public class CuriouslyRecurringGeneric
        extends GenericType<CuriouslyRecurringGeneric> {
}
