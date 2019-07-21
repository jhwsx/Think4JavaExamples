package access;

import java.util.Arrays;

import static net.mindview.simple.Range.range;

/**
 * @author wzc
 * @date 2019/6/14
 */
public class RangeTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(range(5)));
        System.out.println(Arrays.toString(range(2, 5)));
        System.out.println(Arrays.toString(range(2, 5,3)));

    }
}
