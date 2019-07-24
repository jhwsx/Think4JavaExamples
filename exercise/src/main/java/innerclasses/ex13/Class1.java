package innerclasses.ex13;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Class1 {
    Interface1 g() {
        class Interface1Impl implements Interface1 {

            @Override
            public void f() {
                System.out.println("Interface1Impl.f()");
            }
        }
        return new Interface1Impl();
    }

    Interface1 h() {
        return new Interface1() {
            @Override
            public void f() {
                System.out.println("Interface1.f()");
            }
        };
    }

    public static void main(String[] args) {
        Class1 class1 = new Class1();
        Interface1 interface1 = class1.g();
        interface1.f();
        Interface1 h = class1.h();
        h.f();
    }
}
