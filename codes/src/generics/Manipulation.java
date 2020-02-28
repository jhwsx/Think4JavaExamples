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
        // 由於泛型擦除，Java編譯器無法將 manipulate() 必須能夠在 obj 上調用 f() 這一需求隱射到
        // HasF 擁有 f() 這一事實上。
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
