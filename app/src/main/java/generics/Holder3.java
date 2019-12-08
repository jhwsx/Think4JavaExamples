package generics;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Automobile> h3 =
                new Holder3<>(new Automobile());
        // 无需强转
        Automobile a = h3.get();
        // 编译不通过，类型不匹配
//        h3.set("Not an Automobile");
//        h3.set(1);
    }
}
