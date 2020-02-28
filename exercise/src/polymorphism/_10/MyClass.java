package polymorphism._10;

/**
 * @author wzc
 * @date 2019/7/13
 */
class BaseClass {
    void f() {
        System.out.println("BaseClass.f()");
        System.out.println(this);
        g();
    }
    void g() {
        System.out.println("BaseClass.g()");
    }
}

class ClassA extends BaseClass {
    @Override
    void g() {
        System.out.println("ClassA.g()");
    }
}
public class MyClass {
    public static void main(String[] args) {
        BaseClass classA = new ClassA();
        classA.f();
    }
}
