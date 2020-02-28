package exceptions.ex13;


class Exception1 extends Exception {
}

class Exception2 extends Exception {

}

class Exception3 extends Exception {

}

public class Ex13 {
    private static Integer[] x = new Integer[1];
    public static void main(String[] args) {
        try {
            f(x[0]);
            f(1);
            f(0);
            f(-1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally block");
        }
    }

    static void f(int x) throws Exception1, Exception2, Exception3 {
        if (x > 0) throw new Exception1();
        if (x == 0) throw new Exception2();
        throw new Exception3();
    }
}
