package concurrency.ex01;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */

/**
 * Implement a Runnable. Inside run(), print a message, and then call yield().
 * Repeat this three times, and then return from run(). Put a startup message in
 * the constructor and a shutdown message when the task terminates. Create a
 * number of these tasks and drive them using threads.
 **/
class MyRunnable implements Runnable {
    private int id;

    public MyRunnable(int id) {
        this.id = id;
        System.out.println("MyRunnable " + id + " startup");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("MyRunnable " + id + " task index:" + i);
            Thread.yield();
        }
        System.out.println("MyRunnable " + id + " end");
    }
}

public class Ex01 {
    public static void main(String[] args) {
        new Thread(new MyRunnable(1)).start();
        new Thread(new MyRunnable(2)).start();
        new Thread(new MyRunnable(3)).start();
    }
}
