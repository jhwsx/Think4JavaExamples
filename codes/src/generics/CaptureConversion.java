package generics;

/**
 * 捕获转换
 *
 * @author wangzhichao
 * @since 2020/01/01
 */
public class CaptureConversion {
    // 这个方法的类型参数是确切的，没有通配符或边界。
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    // 可以捕获未指定的通配符类型，并把它转为确切类型。
    static void f2(Holder<?> holder) {
//        Object o = holder.get();
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw);
        // 传递原生类型
        f2(raw);

        Holder rawBasic = new Holder();
        rawBasic.set(new Object());

        f2(rawBasic);

        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);
    }
}
