package exceptions.ex10;

class Exception1 extends Exception {
    public Exception1(String message) {
        super(message);
    }
}

class Exception2 extends Exception {
    public Exception2(String message) {
        super(message);
    }

    public Exception2(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Ex10 {
    static void f() throws Exception2{
        try {
            g();
        } catch (Exception1 exception1) {
            // way 1:
//            throw new Exception2("from f()", exception1);
            // way 2:
            Exception2 exception2 = new Exception2("from f()");
            exception2.initCause(exception1);
            throw exception2;
        }
    }

    static void g() throws Exception1 {
        throw new Exception1("throw from g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception2 exception2) {
            exception2.printStackTrace();
        }
    }
}
