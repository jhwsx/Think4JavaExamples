package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MNA {
    private void f() {
        System.out.println("MNA.f()");
    }

    class A {
        private void g() {
            System.out.println("A.g()");
        }

        public class B {
            void h() {
                System.out.println("B.h()");
                g();
                f();
            }
        }
    }

}
public class MutiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
