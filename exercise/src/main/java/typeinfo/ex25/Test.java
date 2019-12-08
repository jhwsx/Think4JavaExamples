package typeinfo.ex25;

import java.lang.reflect.Method;

import typeinfo.ex25.pkg.A;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
public class Test {
    public static void main(String[] args) throws Exception {
        A a = new A();
//        a.f();
//        a.g();
//        a.h();

        Method[] declaredMethods = a.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            method.invoke(a);
        }
    }

}
