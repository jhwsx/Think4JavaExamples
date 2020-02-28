package initialization;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class OverloadingVarargs2 {
    static void f(float i, Character... args) {
        System.out.println("first");
    }

    static void f(Character... args) {
        System.out.println("second");
    }

    public static void main(String[] args) {
        f(1, 'a');
//        f('a', 'b'); // 此行代码会出错，上面的两个方法都符合，'a' 可以自动类型提示为 97.0
        f();
    }
}
