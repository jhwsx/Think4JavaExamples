package generics;

/**
 * @author wangzhichao
 * @since 2019/12/18
 */
class Manipulator2<T extends HasF> {
    private T obj;

    public Manipulator2(T x) {
        obj = x;
    }
    public void manipulate() {
        System.out.println(obj.getClass().getSimpleName()); // 打印 HasF.
        obj.f();
    }
}
public class Manipulation2 {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator2<HasF> manipulator2 =
                new Manipulator2<>(hf);
        manipulator2.manipulate();
    }
}
