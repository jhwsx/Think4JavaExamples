package concurrency.ex08;

/**
 * 不是所有的 run() 方法中的日志都可以输出，
 * 如果在 run() 方法中休眠一秒，效果比较明显。
 *
 * @author wangzhichao
 * @since 2020/3/5
 */
public class Ex08 {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 25; i++) {
                Thread thread = new Thread(new LiftOff());
                thread.setDaemon(true);
                thread.start();
            }
        } finally {
            System.out.println("Finally out of main");
        }
    }
}
