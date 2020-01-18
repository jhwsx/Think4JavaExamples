package arrays.ex01;

/**
 * @author wangzhichao
 * @since 2020/01/18
 */

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}

public class Ex01 {
    public static void main(String[] args) {
        BerylliumSphere[] a;
        a = new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};
        f(a);
        BerylliumSphere[] b = {new BerylliumSphere(), new BerylliumSphere()};
        f(b);

        f(new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()});
        // 编译报错：Array initializer is not allowed here
        // f({new BerylliumSphere(), new BerylliumSphere()});
    }

    static void f(BerylliumSphere[] berylliumSpheres) {}
}
