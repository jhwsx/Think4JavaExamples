package concurrency.ex02;

/**
 * 这个例子有线程同步问题
 *
 * 所有的数字都会打印出来，但是主要问题打印出的序列会错乱。一个斐波那契数列还没打印完毕，就切到另一个斐波那契数列数列的打印。
 *
 * 解决办法是：run() 方法里面加上同步代码块 synchronized(FibonacciRunnable.class)
 * @author wangzhichao
 * @since 2020/3/2
 */
// 这个任务用于产生由 n 个斐波那契数字组成的序列
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
