package generics;

/**
 * 自己执行擦除的例子
 *
 * @author wangzhichao
 * @since 2019/12/18
 */
class Manipulator3 {
    private HasF obj;

    public Manipulator3(HasF x) {
        this.obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}

public class Manipulation3 {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator3 manipulator = new Manipulator3(hf);
        manipulator.manipulate();
    }
}
