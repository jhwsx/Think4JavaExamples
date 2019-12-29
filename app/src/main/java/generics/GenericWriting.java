package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/29
 */
public class GenericWriting {
    /**
     * 这里使用了一个确切参数类型（无通配符）
     * @param list
     * @param item
     * @param <T>
     */
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
        System.out.println(list);
    }

    static List<Apple> apples = new ArrayList<Apple>();

    static List<Fruit> fruit = new ArrayList<Fruit>();

    static void f1() {
        writeExact(apples, new Apple());
        // 向 List<Fruit> 中放入 Apple，是可以的，但是这样不好。
        writeExact(fruit, new Apple());
    }

    /**
     * 参数是 List<? super T>, 表示是参数 T 或者 T 的某种基类型的 List，
     * 因此向其中添加类型 T 或者 T 的子类型是安全的。也就是说，这个 List
     * 会持有类型 T 或者从 T 导出的某种具体类型。
     * @param list
     * @param item
     * @param <T>
     */
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }
    public static void main(String[] args) {
        f1();
        f2();
    }
}
