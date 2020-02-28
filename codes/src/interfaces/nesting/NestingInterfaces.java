package interfaces.nesting;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class A {
    // 默认权限修饰符
    interface B {
        void f();
    }

    public class BImpl implements B {
        @Override
        public void f() {

        }
    }

    private class BImpl2 implements B {
        @Override
        public void f() {

        }
    }
    // public 权限修饰符
    public interface C {
        void f();
    }

    class CImpl implements C {
        @Override
        public void f() {

        }
    }

    private class CImpl2 implements C {
        @Override
        public void f() {

        }
    }

    private interface D {
        void f();
    }

    private class DImpl implements D {
        @Override
        public void f() {

        }
    }

    public class DImpl2 implements D {
        @Override
        public void f() {

        }
    }

    public D getD() {
        return new DImpl2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}

interface E {
    interface G {
        void f();
    }

    public interface H {
        void f();
    }

    void g();

//    private interface I {
//    }


}
public class NestingInterfaces {
    public class BImp implements A.B {

        @Override
        public void f() {

        }
    }

    class CImp implements A.C {
        @Override
        public void f() {

        }
    }

//    class DImp implements A.D {
//
//    }

    class EImp implements E {
        @Override
        public void g() {

        }
    }

    class EGImp implements E.G {
        @Override
        public void f() {

        }
    }

    class EImp2 implements E {
        @Override
        public void g() {

        }

        class EG implements G {

            @Override
            public void f() {

            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
//        A.D ad = a.getD();
        A.DImpl2 dImpl2 = (A.DImpl2) a.getD();
//        a.getD().f();
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}
