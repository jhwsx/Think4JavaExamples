package typeinfo;

import typeinfo.interfacea.A;

import static typeinfo.InnerImplementation.callHiddenMethod;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
class AnonymousA {
    public static A makeA() {
        return new A() {
            @Override
            public void f() {
                System.out.println("public C.f()");
            }

            public void g() {
                System.out.println("public C.g()");
            }

            void u() {
                System.out.println("package C.u()");
            }

            protected void v() {
                System.out.println("protected C.v()");
            }

            private void w() {
                System.out.println("private C.w()");
            }
        };
    }
}
public class AnonymousImplementation {
    public static void main(String[] args) throws Exception {
        A a = AnonymousA.makeA();
        a.f();
        // 下面的方法都获取不到，因为 C 是包访问权限
//        a.g();
//        a.u();
//        a.v();
//        a.w();
        System.out.println(a.getClass().getName());
        // 不能发现 C
//        if (a instanceof C) {
//            C c = (C) a;
//            c.g();
//        }
        // 使用反射，可以调用
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }
}
