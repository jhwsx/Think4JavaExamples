package typeinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import typeinfo.interfacea.A;
import typeinfo.packageaccess.HiddenC;

import static typeinfo.InnerImplementation.callHiddenMethod;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
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
