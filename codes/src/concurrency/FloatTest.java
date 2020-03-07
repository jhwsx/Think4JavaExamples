package concurrency;

/**
 * @author wangzhichao
 * @since 2020/3/6
 */
public class FloatTest {
    public static void main(String[] args) {
        Float f1 = -1.0f / 0.0f;
        System.out.println("f1 = " + f1);
        System.out.println("Float.isNaN(f1) = " + Float.isNaN(f1));
        System.out.println("Float.isInfinite(f1) = " + Float.isInfinite(f1));
        System.out.println("Float.isFinite(f1) = " + Float.isFinite(f1));
        Float f2 = 0.0f / 0.0f;
        System.out.println("f2 = " + f2);
        System.out.println("Float.isNaN(f2) = " + Float.isNaN(f2));
        System.out.println("Float.isInfinite(f2) = " + Float.isInfinite(f2));
        System.out.println("Float.isFinite(f2) = " + Float.isFinite(f2));
    }
}
