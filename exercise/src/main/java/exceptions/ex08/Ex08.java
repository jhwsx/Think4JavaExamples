package exceptions.ex08;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Exception8 extends Exception {
}

public class Ex08 {

    public void f() throws Exception8 {
        throw new Exception8();
    }
    public static void main(String[] args) {
    }
}
