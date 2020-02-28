package interfaces._06;

import interfaces._06.me.MyInterface;
import interfaces._06.mi.MyInterfaceImpl;

/**
 * @author wzc
 * @date 2019/7/16
 */
public class Test {
    public static void main(String[] args) {
        MyInterface xx = new MyInterfaceImpl();
        xx.f();
        xx.g();
        xx.h();
    }
}
