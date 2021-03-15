package concurrency;

/**
 * 一个基于控制台用户界面的例子
 *
 * @author wangzhichao
 * @since 2020/3/7
 */
// 这个版本是关注于运算，所以不能读取控制台输入
class UnresponsiveUI {
    private volatile double d = 1;

    public UnresponsiveUI() throws Exception {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        System.in.read();
    }
}
// 这个版本把运算放在单独的任务里执行，所以可以在进行运算的同时监听控制台输入
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;
    public ResponsiveUI() {
        // 设置后台线程（一定要在 start() 方法调用之前。）设置这一行的作用是在 main 线程结束后，就结束掉这个线程。
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
//            System.out.println(d);
        }
    }

    public static void main(String[] args) throws Exception {
//        new UnresponsiveUI();
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
