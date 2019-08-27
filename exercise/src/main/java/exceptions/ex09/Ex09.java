package exceptions.ex09;


class Exception1 extends Exception {
}

class Exception2 extends Exception {

}

class Exception3 extends Exception {

}

public class Ex09 {
    public static void main(String[] args) {
        try {
            f(1);
            f(0);
            f(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void f(int x) throws Exception1, Exception2, Exception3 {
        if (x > 0) throw new Exception1();
        if (x == 0) throw new Exception2();
        throw new Exception3();
    }
}
