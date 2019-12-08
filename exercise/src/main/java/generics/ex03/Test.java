package generics.ex03;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
public class Test {
    static SixTuple<Boolean, String, Integer, Float, Double, Short> f() {
        return new SixTuple<>(false, "good", 1, 2f, 3.0, Short.valueOf("0"));
    }

    public static void main(String[] args) {
        System.out.println(f());
    }
}
