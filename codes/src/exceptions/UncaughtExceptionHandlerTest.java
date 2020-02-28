package exceptions;

/**
 * @author wangzhichao
 * @since 2020/01/10
 */
public class UncaughtExceptionHandlerTest {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("出异常了：" + e);
            }
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 5 / 0;
            }
        });
        thread.start();
    }
}
