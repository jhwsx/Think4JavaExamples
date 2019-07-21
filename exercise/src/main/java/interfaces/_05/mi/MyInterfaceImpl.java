package interfaces._05.mi;

import interfaces._05.me.MyInterface;

/**
 * @author wzc
 * @date 2019/7/16
 */
public class MyInterfaceImpl implements MyInterface {
    @Override
    public void f() {
        System.out.println("f()");
    }

    @Override
    public void g() {
        System.out.println("g()");
    }

    @Override
    public void h() {
        System.out.println("h()");
    }
}
