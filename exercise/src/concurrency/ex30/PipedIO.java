package concurrency.ex30;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 任务间使用管道进行输入与输出
 *
 * PipedReader 是可中断的；而普通的 I/O 是不可中断的。
 *
 * @author wangzhichao
 * @since 2021/4/8
 */
class Sender implements Runnable {
    private Random rand = new Random(47);
    private CharacterQueue characterQueue;

    public Sender(CharacterQueue characterQueue) {

        this.characterQueue = characterQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    characterQueue.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {
    private CharacterQueue characterQueue;

    public Receiver(CharacterQueue characterQueue) {

        this.characterQueue = characterQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Blocks until characters are there:
                System.out.print("Read: " + (char) characterQueue.take() + ", ");
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}

class CharacterQueue extends LinkedBlockingQueue<Character> {}

public class PipedIO {
    public static void main(String[] args) throws Exception {
        CharacterQueue characterQueue = new CharacterQueue();
        Sender sender = new Sender(characterQueue);
        Receiver receiver = new Receiver(characterQueue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
