package generics;

import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/27
 */
public class SuperTypeWildcards {
    /**
     * 参数是 Apple 或者 Apple 的某种基类型的 List，所以向其中添加 Apple 或者 Apple 的子类型是安全的。
     * @param apples
     */
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // 編譯不通過， Fruit 并非 Apple 的子类型。
//        apples.add(new Fruit());
    }

    // 注意：没有 <T super MyClass> 这种写法
//    static <T> void writeTo2(List<T super Apple> apples) {}
}
