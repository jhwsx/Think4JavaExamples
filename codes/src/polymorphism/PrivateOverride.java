package polymorphism;

/**
 * 私有方法不可以覆盖
 * @author wzc
 * @date 2019/7/13
 */
public class PrivateOverride {
    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
        Derived derived = new Derived();
        derived.f();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f()");
    }
}
