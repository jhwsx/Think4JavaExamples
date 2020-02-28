package generics;

/**
 * 自限定泛型：将产生确切的导出类型作为其返回值
 *
 * @author wangzhichao
 * @since 2020/01/05
 */
interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {

}

public class GenericsAndReturnTypes {

    static void test(Getter g) {
        Getter result = g.get();
        GenericGetter gg = g.get();
    }
}
