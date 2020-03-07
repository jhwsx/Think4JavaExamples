package concurrency.ex02;

/**
 * 这个例子有线程同步问题
 *
 * @author wangzhichao
 * @since 2020/3/2
 */
class FibonacciRunnable implements Runnable {
    private int count = 0;

    public FibonacciRunnable(int count) {
        this.count = count;
    }

    @Override
    public void run() {
//        System.out.println("start: " + count);
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < count; i++) {
            System.out.print(gen.next() + " ");
        }
        System.out.println();
//        System.out.println("end: " + count);
    }
}

public class Ex02 {
    public static void main(String[] args) {
        new Thread(new FibonacciRunnable(1)).start();
        new Thread(new FibonacciRunnable(2)).start();
        new Thread(new FibonacciRunnable(3)).start();
        new Thread(new FibonacciRunnable(4)).start();
        new Thread(new FibonacciRunnable(5)).start();
        new Thread(new FibonacciRunnable(6)).start();
    }
}
