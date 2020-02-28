package generics;

import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

/**
 * 自动包装机制不能应用于数组
 *
 * @author wangzhichao
 * @since 2020/01/04
 */
// 使用生成器来填充一个数组。
class FArray {
    public static <T> T[] fill(T[] a, Generator<T> gen) {
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.next();
        }
        return a;
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7], new RandomGenerator.String(10));
        for (String s : strings) {
            System.out.println(s);
        }
        Integer[] integers = FArray.fill(new Integer[7], new RandomGenerator.Integer());
        for (Integer i : integers) {
            System.out.println(i);
        }
        // int[] 不能自动装箱为 Integer[]
//        FArray.fill(new int[7], new RandomGenerator.Integer());
    }
}
