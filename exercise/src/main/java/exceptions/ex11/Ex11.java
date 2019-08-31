package exceptions.ex11;


class Exception2 extends Exception {
    public Exception2(String message) {
        super(message);
    }

    public Exception2(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Ex11 {
    static void f() throws Exception2 {
        try {
            g();
        } catch (RuntimeException exception1) {
            // way 1:
//            throw new Exception2("from f()", exception1);
            // way 2:
            Exception2 exception2 = new Exception2("from f()");
            exception2.initCause(exception1);
            throw exception2;
        }
    }

    static void g() throws RuntimeException {
        throw new RuntimeException("throw from g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception2 exception2) {
            exception2.printStackTrace();
        }
    }
}
