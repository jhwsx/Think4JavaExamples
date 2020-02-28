package arrays.ex14;

import net.mindview.util.ConvertTo;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

/**
 * @author wzc
 * @date 2020/2/1
 */
public class Ex14 {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = ConvertTo.primitive(Generated.array(
                Boolean.class, new CountingGenerator.Boolean(), size
        ));
        System.out.println("Arrays.toString(a1) = " + Arrays.toString(a1));
        byte[] a2 = ConvertTo.primitive(Generated.array(
                Byte.class, new CountingGenerator.Byte(), size));
        System.out.println("Arrays.toString(a2) = " + Arrays.toString(a2));
        char[] a3 = ConvertTo.primitive(Generated.array(
                Character.class, new CountingGenerator.Character(), size
        ));
        System.out.println("Arrays.toString(a3) = " + Arrays.toString(a3));
        short[] a4 = ConvertTo.primitive(Generated.array(
                Short.class, new CountingGenerator.Short(), size
        ));
        System.out.println("Arrays.toString(a4) = " + Arrays.toString(a4));
        int[] a5 = ConvertTo.primitive(Generated.array(
                Integer.class, new CountingGenerator.Integer(), size
        ));
        System.out.println("Arrays.toString(a5) = " + Arrays.toString(a5));
        float[] a6 = ConvertTo.primitive(Generated.array(
                Float.class, new CountingGenerator.Float(), size
        ));
        System.out.println("Arrays.toString(a6) = " + Arrays.toString(a6));
        double[] a7 = ConvertTo.primitive(Generated.array(
                Double.class, new CountingGenerator.Double(), size
        ));
        System.out.println("Arrays.toString(a7) = " + Arrays.toString(a7));
    }
}
