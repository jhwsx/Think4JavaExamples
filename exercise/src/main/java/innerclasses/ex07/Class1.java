package innerclasses.ex07;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   : 打破了封装
 *     version: 1.0
 * </pre>
 */
public class Class1 {
    private String string = "outer";
    private void f() {
        System.out.println("Class1.f()");
    }

    void show() {
        Inner inner = new Inner();
        inner.change();
    }
    void showString() {
        System.out.println(string);
    }
    class Inner {
        void change() {
            string = "inner";
            f();
        }
    }

    public static void main(String[] args) {
        Class1 class1 = new Class1();
        class1.showString();
        class1.show();
        class1.showString();
    }
}
