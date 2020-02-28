package innerclasses.ex12;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/24
 *     desc   : 打破了封装
 *     version: 1.0
 * </pre>
 */

interface InterfaceChange {
    void change();
}
public class Class1 {
    private String string = "outer";
    private void f() {
        System.out.println("Class1.f()");
    }


    void showString() {
        System.out.println(string);
    }


    public InterfaceChange inner() {
        return new InterfaceChange() {
            @Override
            public void change() {
                string = "inner";
                f();
            }
        };
    }

    public static void main(String[] args) {
        Class1 class1 = new Class1();
        class1.showString();
        class1.inner().change();
        class1.showString();
    }
}
