package arrays;

import net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author wzc
 * @date 2020/2/19
 */
public class Reverse {
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        System.out.println("before sorting");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Collections.<CompType>reverseOrder());
        System.out.println("after sorting");
        System.out.println(Arrays.toString(a));
    }
}
