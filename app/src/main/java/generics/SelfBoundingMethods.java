package generics;

/**
 * 自限定用于泛型方法：防止传入自限定参数之外的任何事物
 *
 * @author wangzhichao
 * @since 2020/01/05
 */
class Haha {}
public class SelfBoundingMethods {
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
        //f(new Haha());
    }
}
