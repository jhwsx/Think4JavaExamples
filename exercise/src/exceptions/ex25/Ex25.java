package exceptions.ex25;

class Exception1 extends Exception {}

class Exception2 extends Exception1 {}

class Exception3 extends Exception2 {}

class A {
    public void f() throws Exception1 {}
}

class B extends A {
    public void f() throws Exception2 {}
}

class C extends B {
    public void f() throws Exception3 {}
}
public class Ex25 {
    public static void main(String[] args) {
        try {
            A a = new C();
            a.f();
        } catch (Exception1 exception1) {
            exception1.printStackTrace();
        }
    }
}
