package arrays;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author wzc
 * @date 2020/2/19
 */
public class StringSorting {
    public static void main(String[] args) {
        String[] sa = Generated.array(new String[20],
                new RandomGenerator.String(5));
        System.out.println("Before sort: " + Arrays.toString(sa));
        // 自然排序
        Arrays.sort(sa);
        System.out.println("After sort: " + Arrays.toString(sa));
        // 倒自然排序
        Arrays.sort(sa, Collections.<String>reverseOrder());
        System.out.println("Reverse sort: " + Arrays.toString(sa));
        // 忽略大小写字母，自然排序
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort: " + Arrays.toString(sa));
    }
}
