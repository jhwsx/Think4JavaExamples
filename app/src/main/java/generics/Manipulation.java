package generics;

/**
 * @author wangzhichao
 * @since 2019/12/18
 */
class Manipulator<T> {
    private T obj;
    public Manipulator(T x) {
        obj = x;
    }
    public void manipulate() {
        System.out.println(obj.getClass().getSimpleName()); // 这段打印出来是 HasF。
        // 不能理解 f() 方法, 如果是 C++ 代码，这段就可以编译通过
//        obj.f();
    }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator =
                new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
