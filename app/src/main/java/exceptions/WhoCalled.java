package exceptions;

public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.out.println(stackTraceElement.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("--------------------------");
        g();
        System.out.println("--------------------------");
        h();
    }
}
