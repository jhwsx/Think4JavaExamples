package arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

/**
 * @author wzc
 * @date 2020/2/1
 */
public class PrimitiveConversionDemonstration {
    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        // String toString(Object[] a)
        System.out.println(Arrays.toString(a));
        int[] b = ConvertTo.primitive(a);
        // String toString(int[] a)
        System.out.println(Arrays.toString(b));
        boolean[] c = ConvertTo.primitive(
                Generated.array(Boolean.class, new CountingGenerator.Boolean(), 7)
        );
        System.out.println(Arrays.toString(c));
    }
}
