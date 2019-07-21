package interfaces._13;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface InterfaceA {
    void a();
}

interface InterfaceB extends InterfaceA{
    void b();
}

interface InterfaceC extends InterfaceA {
    void c();
}

interface InterfaceD extends InterfaceB, InterfaceC {
    void d();
}

class InterfaceDImpl implements InterfaceD {
    @Override
    public void a() {
        System.out.println("a()");
    }

    @Override
    public void b() {
        System.out.println("b()");
    }

    @Override
    public void c() {
        System.out.println("c()");
    }

    @Override
    public void d() {
        System.out.println("d()");
    }
}
public class Ex13 {
    public static void main(String[] args) {
        InterfaceDImpl impl = new InterfaceDImpl();
        impl.a();
    }
}
