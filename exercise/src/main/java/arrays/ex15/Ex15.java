package arrays.ex15;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.Arrays;

/**
 * @author wzc
 * @date 2020/2/1
 */
class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {

    @Override
    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}

public class Ex15 {
    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres = Generated.array(BerylliumSphere.class, new BerylliumSphereGenerator(), 8);
        System.out.println("Arrays.toString(berylliumSpheres) = " + Arrays.toString(berylliumSpheres));
    }
}
