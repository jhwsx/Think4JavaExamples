package arrays.ex18;

import java.util.Arrays;

import arrays.ex06.BerylliumSphere;

/**
 * 证明 System.arraycopy 对于对象数组是浅拷贝（shallow copy）。
 * @author wzc
 * @date 2020/2/3
 */
public class Ex18 {
    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres = {
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere()
        };
        BerylliumSphere[] berylliumSpheres1 = new BerylliumSphere[8];
        System.out.println("Arrays.toString(berylliumSpheres) = " + Arrays.toString(berylliumSpheres));
        System.arraycopy(berylliumSpheres, 0, berylliumSpheres1, 0, berylliumSpheres.length);
        System.out.println("Arrays.toString(berylliumSpheres1) = " + Arrays.toString(berylliumSpheres1));

    }
}
