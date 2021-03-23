package concurrency;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * I/O 任务不可以通过线程的 interrupt() 方法来中断，但是可以通过关闭底层的资源来中断阻塞的任务
 *
 * @author wangzhichao
 * @since 2020/3/31
 */
public class CloseResource {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080); // 这行会抛出 IOException
        InputStream socketInput =
                new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Shutting down all threads");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + socketInput.getClass().getSimpleName());
        socketInput.close(); // Release blocked thread
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + System.in.getClass().getSimpleName());
        System.in.close(); // todo 这里好像没有关闭掉
    }
}
