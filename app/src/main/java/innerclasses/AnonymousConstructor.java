package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }

    public abstract void f();
}
public class AnonymousConstructor {
    public static Base getBase(int i) { // 这个 i 不用是 final 的，因为它没有在匿名内部类内部被直接使用
        return new Base(i) {
            {
                System.out.println("Inside instance initializer" + this);
            }
            @Override
            public void f() {
                System.out.println("In Anonymous f()");
            }

        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
