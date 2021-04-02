package concurrency.ex24;

/**
 * @author wangzhichao
 * @since 2021/3/31
 */

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Solve a single-producer, single consumer problem using wait() and
 * notifyAll(). The producer must not overflow the receiver's buffer,
 * which can happen if the producer is faster than the consumer. If the
 * consumer is faster than the producer, then it must not read the same
 * data more than once. Do not assume anything about the relative speeds
 * of the producer or consumer.
 * 单生产者，单消费者，带缓存队列的例子
 **/
class Apk {
    private static int counter = 0;
    private final int versionCode = ++counter;

    public Apk() {
    }

    @Override
    public String toString() {
        return "Apk " + versionCode;
    }
}

class Coder implements Runnable {
    private Team team;

    public Coder(Team team) {
        this.team = team;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (team.count == team.apkArray.length) { // 缓冲区已满
                        wait();
                    }
                }
                synchronized (team.tester) {
                    Apk apk = new Apk();
                    team.apkArray[team.putPtr] = apk;
                    ++team.count;
                    System.out.println("<<<<<发布：" + apk + ",count = " + team.count + ", 缓存区：" + Arrays.toString(team.apkArray));
                    if (++team.putPtr == team.apkArray.length) team.putPtr = 0;
                    team.tester.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(0L);
            }
        } catch (InterruptedException e) {
            System.out.println("Coder interrupted.");
        }
    }
}

class Tester implements Runnable {

    private final Team team;

    public Tester(Team team) {
        this.team = team;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (team.count == 0) { // 缓冲区没有东西
                        wait();
                    }
                }
                synchronized (team.coder) {
                    int testedIndex = team.takePtr;
                    if (++team.takePtr == team.apkArray.length) team.takePtr = 0;
                    --team.count;
                    System.out.print("====================>>>>>>>Test " + team.apkArray[testedIndex] + ", index = " + testedIndex                     );
                    team.apkArray[testedIndex] = null;
                    System.out.println(" count = " + team.count + ", 缓冲区：" + Arrays.toString(team.apkArray));
                    team.coder.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(0L);
            }
        } catch (InterruptedException e) {
            System.out.println("Tester interrupted.");
        }
    }
}

public class Team {
    Apk[] apkArray = new Apk[5];
    int putPtr, takePtr, count;
    ExecutorService exec = Executors.newCachedThreadPool();
    final Coder coder = new Coder(this);
    final Tester tester = new Tester(this);

    public Team() {
        exec.execute(coder);
        exec.execute(tester);
    }

    public static void main(String[] args) {
        new Team();
    }
}
