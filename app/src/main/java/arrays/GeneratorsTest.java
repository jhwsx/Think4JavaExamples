package arrays;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;

/**
 * 使用数据生成器来创建更有意义的数组
 *
 * @author wzc
 * @date 2020/2/1
 */
public class GeneratorsTest {
    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.println(type.getSimpleName() + ": ");
            try {
                Generator<?> generator = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.print(generator.next() + " ");
                }
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);
    }
}
