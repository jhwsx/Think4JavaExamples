package arrays.ex16;

import net.mindview.util.ConvertTo;

import java.util.Arrays;

/**
 * @author wzc
 * @date 2020/2/1
 */
public class Ex16 {
    public static void main(String[] args) {
        int size = 6;
        int skip = 7;
        boolean[] a1 = ConvertTo.primitive(Generated16.array(
                new Boolean[size], new SkipGenerator16.Boolean(skip), size
        ));
        System.out.println("Arrays.toString(a1) = " + Arrays.toString(a1));
        byte[] a2 = ConvertTo.primitive(Generated16.array(
                new Byte[size], new SkipGenerator16.Byte(skip), size));
        System.out.println("Arrays.toString(a2) = " + Arrays.toString(a2));
        char[] a3 = ConvertTo.primitive(Generated16.array(
                new Character[size], new SkipGenerator16.Character(skip), size
        ));
        System.out.println("Arrays.toString(a3) = " + Arrays.toString(a3));
        short[] a4 = ConvertTo.primitive(Generated16.array(
                new Short[size], new SkipGenerator16.Short(skip), size
        ));
        System.out.println("Arrays.toString(a4) = " + Arrays.toString(a4));
        int[] a5 = ConvertTo.primitive(Generated16.array(
                new Integer[size], new SkipGenerator16.Integer(skip), size
        ));
        System.out.println("Arrays.toString(a5) = " + Arrays.toString(a5));
        float[] a6 = ConvertTo.primitive(Generated16.array(
                new Float[size], new SkipGenerator16.Float(skip), size
        ));
        System.out.println("Arrays.toString(a6) = " + Arrays.toString(a6));
        double[] a7 = ConvertTo.primitive(Generated16.array(
                new Double[size], new SkipGenerator16.Double(skip), size
        ));
        System.out.println("Arrays.toString(a7) = " + Arrays.toString(a7));
    }
}
