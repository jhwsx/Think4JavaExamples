package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程与线程组的关系有点类似于 View 与 ViewGroup 的关系
 * <p>
 * 参考资料：https://www.cnblogs.com/yiwangzhibujian/p/6212104.html
 *
 * @author wangzhichao
 * @since 2020/3/7
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        // 使用静态方法，设置一个默认的未捕获异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
