package exceptions.ex02;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyClass {
    void f() {

    }
}
public class Ex02 {
    public static void main(String[] args) {
        MyClass myClass = null;

        try {
            myClass.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
