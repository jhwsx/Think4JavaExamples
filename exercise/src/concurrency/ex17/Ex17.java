package concurrency.ex17;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create a radiation counter that can have any number of remote sensors.
 *
 * @author wangzhichao
 * @since 2020/3/30
 */
class RadiantionCounter {
    private Random random = new Random(47);
    private int count;

    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

class Sensor implements Runnable {
    private static RadiantionCounter counter = new RadiantionCounter();
    private static List<Sensor> sensors = new ArrayList<>();
    // 每个 Sensor 自己记录的数据
    private int number;
    // 终止程序的标记
    private static volatile boolean canceled = false;

    public static void cancel() {
        canceled = true;
    }

    // Sensor 的 id，以示区分
    private final int id;

    public Sensor(int id) {
        this.id = id;
        sensors.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                number++;
            }
            System.out.println(this + " Total: " + counter.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return counter.value();
    }

    public static int sumSensors() {
        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.getValue();
        }
        return sum;
    }
}

public class Ex17 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Sensor(i));
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Sensor.cancel();
        exec.shutdown();
        // 在超时超过 250 ms 之后，终止任务
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated");
        }
        System.out.println("Total: " + Sensor.getTotalCount());
        System.out.println("Sum of Entrances: " + Sensor.sumSensors());
    }
}
