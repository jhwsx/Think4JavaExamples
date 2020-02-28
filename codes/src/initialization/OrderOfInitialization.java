package initialization;

/**
 * @author wzc
 * @date 2019/6/5
 */
public class OrderOfInitialization {
    public static void main(String[] args) {
        House house = new House();
        house.f();
    }
}

class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class House {
    Window w1 = new Window(1); // 在构造方法之前

    public House() {
        System.out.println("House()");
        w3 = new Window(33); // 在构造方法中重新赋值
    }

    Window w2 = new Window(2); // 在构造方法之后
    void f() {
        System.out.println("f()");
    }
    Window w3 = new Window(3); // 在普通方法之后
}
