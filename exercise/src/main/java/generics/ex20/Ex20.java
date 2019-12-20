package generics.ex20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/18
 */
// TIJ4 Chapter Generics, Exercise 20, page 654
/* Create an interface with two methods, and a class that implements that interface
 * and adds another method. In another class, create a generic method with an
 * argument type that is bounded by the interface, and show that the methods in the
 * interface are callable inside this generic method. In main(), pass an instance of
 * the implementing class to the generic method.
 */
interface Callback {
    void a();

    void b();
}

class AnotherClass {
    public <T extends Callback> void f(T t) {
        t.a();
        t.b();
//        t.c();
    }
}
class CallbackImpl implements Callback {

    @Override
    public void a() {
        System.out.println("a()");
    }

    @Override
    public void b() {
        System.out.println("b()");
    }

    public void c() {
        System.out.println("c()");
    }
}
public class Ex20 {
    public static void main(String[] args) {
        AnotherClass anotherClass = new AnotherClass();
        CallbackImpl callback = new CallbackImpl();
        anotherClass.f(callback);
    }
}
