package generics;

/**
 * @author wangzhichao
 * @since 2019/12/19
 */
class GenericBase<T> {
    private T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {
}

// 使用泛型并不是强制的
class Derived2 extends GenericBase {

}
// 这里不能使用通配符 ?
//class Derived3 extends GenericBase<?> {
//
//}

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        Object obj = derived2.get();
        // 这里有警告
        derived2.set(obj);
    }
}
