package exceptions.ex01;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex01 {

    public static void f() throws Exception {
        throw new Exception("Throwing Exception in f()");
    }
    public static void main(String[] args) {
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally block");
        }
    }
}
