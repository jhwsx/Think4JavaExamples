package concurrency.ex15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create a class with three methods containing critical sections
 * that all synchronize on the same object. Create multiple tasks to
 * demonstrate that only one of these methods can run at a time. Now
 * modify the methods so that each one synchronizes on a different
 * object and show that all three methods can be running at once.
 *
 * @author wangzhichao
 * @since 2020/3/13
 **/
class MyClass {
    private Object obj = new Object();
    private Object obj1 = new Object();
    private Object obj2 = new Object();
    private Object obj3 = new Object();

    public void f() {
//        synchronized (obj) {
        synchronized (obj1) {
            for (int i = 0; i < 5; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        }
    }

    public void g() {
//        synchronized (obj) {
        synchronized (obj2) {
            for (int i = 0; i < 3; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    public void h() {
//        synchronized (obj) {
        synchronized (obj3) {
            for (int i = 0; i < 4; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        }
    }
}

class Runnable1 implements Runnable {
    private MyClass myClass;

    Runnable1(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        while (true) {
            myClass.f();
        }
    }
}

class Runnable2 implements Runnable {
    private MyClass myClass;

    Runnable2(MyClass myClass) {
        this.myClass = myClass;
    }
    @Override
    public void run() {
        while (true) {
            myClass.g();
        }
    }
}

class Runnable3 implements Runnable {
    private MyClass myClass;

    Runnable3(MyClass myClass) {
        this.myClass = myClass;
    }
    @Override
    public void run() {
        while (true) {
            myClass.h();
        }
    }
}
public class Ex15 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Runnable1(myClass));
        exec.execute(new Runnable2(myClass));
        exec.execute(new Runnable3(myClass));
        exec.shutdown();
    }
}
