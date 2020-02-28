package arrays.ex23;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author wzc
 * @date 2020/2/19
 */
public class Ex23 {
    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        Random random = new Random(47);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        System.out.println("Before sorting: " + Arrays.toString(a));
        Arrays.sort(a, Collections.<Integer>reverseOrder());
        System.out.println("After sorting: " + Arrays.toString(a));
    }
}
