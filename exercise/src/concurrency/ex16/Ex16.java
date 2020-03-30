package concurrency.ex16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangzhichao
 * @since 2020/3/13
 */
class MyClass {
    private Lock lock = new ReentrantLock();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();

    public void f() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public void g() {
        lock.lock();
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public void h() {
        lock.lock();
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public void f1() {
        lock1.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        } finally {
            lock1.unlock();
        }
    }

    public void g1() {
        lock2.lock();
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        } finally {
            lock2.unlock();
        }
    }

    public void h1() {
        lock3.lock();
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        } finally {
            lock3.unlock();
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
//            myClass.f();
            myClass.f1();
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
//            myClass.g();
            myClass.g1();
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
//            myClass.h();
            myClass.h1();
        }
    }
}
public class Ex16 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Runnable1(myClass));
        exec.execute(new Runnable2(myClass));
        exec.execute(new Runnable3(myClass));
        exec.shutdown();
    }
}
