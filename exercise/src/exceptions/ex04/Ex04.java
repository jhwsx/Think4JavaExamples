package exceptions.ex04;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyException extends Exception {

    private String msg;
    public MyException() {

    }

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public void showMsg() {
        System.out.println(msg);
    }
}
public class Ex04 {
    static void g() throws MyException {
        throw new MyException("Throwing Exception in g()");
    }
    public static void main(String[] args) {
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
            e.showMsg();
        }
    }
}
