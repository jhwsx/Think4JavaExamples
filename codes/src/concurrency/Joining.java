package concurrency;

/**
 * 理解 Thread 类的 join 成员方法
 *
 * public final synchronized void join(long millis) throws InterruptedException
 * public final synchronized void join(long millis, int nanos) throws InterruptedException
 * public final void join() throws InterruptedException 内部实现是 join(0)
 *
 * @author wangzhichao
 * @since 2020/3/6
 */
class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            // sleep 方法可能在指定的时间期满时返回，但也有可能被中断（这种情况需要处理捕获的异常。）
            sleep(duration);
        } catch (InterruptedException e) {
            // 当异常捕获时，将清理 isInterrupted() 的标记，所以在 catch 子句中 isInterrupted() 这个标记的值总是为 false。
            System.out.println(getName() + " was interrupted. " +
                    "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened.");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            // 加入一个线程：sleeper 会先执行，当前线程要等 sleeper 线程结束后才继续执行。
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed.");
    }
}
public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);

        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc = new Joiner("Doc", grumpy);
        // 中断 join() 方法的调用。这里是 grumpy 之前调用了 join() 方法，
        // 现在调用 grumpy.interrupt() 中断之前 join() 方法。
        grumpy.interrupt();
    }
}
/*
打印结果：
Grumpy was interrupted. isInterrupted(): false （这里是false，因为异常被捕获时，清除了这个标记。）
Doc join completed.
Sleepy has awakened.
Dopey join completed.
 */
