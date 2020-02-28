package arrays.ex12;

import net.mindview.util.CountingGenerator;

import java.util.Arrays;

/**
 * @author wzc
 * @date 2020/2/1
 */
public class Ex12 {
    public static void main(String[] args) {
        double[] doubles = new double[8];
        CountingGenerator.Double doubleGenerator = new CountingGenerator.Double();
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = doubleGenerator.next();
        }
        System.out.println("Arrays.toString(doubles) = " + Arrays.toString(doubles));
    }
}
