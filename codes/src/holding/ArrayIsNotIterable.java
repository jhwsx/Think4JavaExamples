package holding;

import java.util.Arrays;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"one", "two", "three"};
//        test(strings);
        // test
        // (java.lang.Iterable<java.lang.Object>)
        //         in ArrayIsNotIterable cannot be applied
        //         to
        // (java.lang.String[])
        test(Arrays.asList(strings));
    }
}
