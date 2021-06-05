package concurrency.ex33;

import java.util.*;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author wangzhichao
 * @since 2021/6/5
 */
abstract class DelayedGreenhouseTask implements Runnable, Delayed {
    // 毫秒值
    protected long delayTime;
    // in NANOSECONDS
    public long trigger;

    public DelayedGreenhouseTask() {
        delayTime = 0;
        trigger = System.nanoTime();
    }

    public DelayedGreenhouseTask(long d) {
        delayTime = d;
        // 把 delayTime 按毫秒转为 NANOSECONDS
        trigger = System.nanoTime() + NANOSECONDS.convert(delayTime, MILLISECONDS);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedGreenhouseTask that = (DelayedGreenhouseTask) o;
        if (trigger < that.trigger) return -1;
        if (trigger > that.trigger) return 1;
        return 0;
    }

    public abstract DelayedGreenhouseTask create(long d);

    @Override
    public abstract void run();
}

class GreenhouseController {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";
    DelayQueue<DelayedGreenhouseTask> tasks = new DelayQueue<>();

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }

    class LightOn extends DelayedGreenhouseTask {

        public LightOn() {
        }

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public DelayedGreenhouseTask create(long d) {
            return new LightOn(d);
        }

        @Override
        public void run() {
            if (!light) {
                System.out.println("Turning on lights");
                light = true;
            }
        }
    }

    class LightOff extends DelayedGreenhouseTask {

        public LightOff() {
        }

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public DelayedGreenhouseTask create(long d) {
            return new LightOff(d);
        }

        @Override
        public void run() {
            if (light) {
                System.out.println("Turning off lights");
                light = false;
            }
        }
    }

    class WaterOn extends DelayedGreenhouseTask {

        public WaterOn() {
        }

        public WaterOn(long d) {
            super(d);
        }

        @Override
        public DelayedGreenhouseTask create(long d) {
            return new WaterOn(d);
        }

        @Override
        public void run() {
            System.out.println("Turning greenhouse water on");
            water = true;
        }
    }

    class WaterOff extends DelayedGreenhouseTask {

        public WaterOff() {
        }

        public WaterOff(long d) {
            super(d);
        }

        @Override
        public DelayedGreenhouseTask create(long d) {
            return new WaterOff(d);
        }

        @Override
        public void run() {
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }

    class ThermostatNight extends DelayedGreenhouseTask {

        public ThermostatNight() {
        }

        public ThermostatNight(long d) {
            super(d);
        }

        @Override
        public DelayedGreenhouseTask create(long d) {
            return new ThermostatNight(d);
        }

        @Override
        public void run() {
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }

    class ThermostatDay extends DelayedGreenhouseTask {

        public ThermostatDay() {
        }

        public ThermostatDay(long d) {
            super(d);
        }

        @Override
        public DelayedGreenhouseTask create(long d) {
            return new ThermostatDay(d);
        }

        @Override
        public void run() {
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }

    class Bell extends DelayedGreenhouseTask {

        public Bell() {
        }

        public Bell(long d) {
            super(d);
        }

        @Override
        public DelayedGreenhouseTask create(long d) {
            return new Bell(d);
        }

        @Override
        public void run() {
            System.out.println("Bing!");
        }
    }

    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            return time.getTime() + String.format(" temperature: %1$.1f humidity: %2$.2f", temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    {
        // Adjust date to the half hour
        lastTime.add(Calendar.MINUTE, 30);
        lastTime.add(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private final Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());

    class CollectData extends DelayedGreenhouseTask {

        public CollectData() {
        }

        public CollectData(long d) {
            super(d);
        }

        @Override
        public DelayedGreenhouseTask create(long d) {
            return new CollectData(d);
        }

        @Override
        public void run() {
            System.out.println("Collecting data");
            synchronized (GreenhouseController.this) {
                // Pretend the interval is longer than it is:
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
                // 有 1/5 的几率来反转方向
                if (rand.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                // 保存之前的值
                lastTemp += tempDirection * (1.0F + rand.nextFloat());
                if (rand.nextInt(5) == 4) {
                    humidityDirection = -humidityDirection;
                }
                lastHumidity += humidityDirection * rand.nextFloat();
                // Calendar 必须被克隆，否则 all DataPoints hold references to the same lastTime.
                data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }

    class StopController extends DelayedGreenhouseTask {

        private ExecutorService exec;

        public StopController(long d, ExecutorService exec) {
            super(d);
            this.exec = exec;
        }

        @Override
        public DelayedGreenhouseTask create(long d) {
            return new StopController(d, Executors.newCachedThreadPool());
        }

        @Override
        public void run() {
            System.out.println("Calling shutdownNow()");
            exec.shutdownNow();
            // 必须开一个单独的任务来做这个工作
            // 因为线程池已经被关闭了
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (DataPoint dataPoint : data) {
                        System.out.println(dataPoint);
                    }
                }
            }).start();
        }
    }

    static class GreenhouseGo implements Runnable {
        private DelayQueue<DelayedGreenhouseTask> q;

        public GreenhouseGo(DelayQueue<DelayedGreenhouseTask> q) {
            this.q = q;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    q.take().run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished GreenhouseGo");
        }
    }
}

public class GreenhouseScheduler {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        GreenhouseController ghc = new GreenhouseController();
        repeat(ghc, ghc.new Bell(), 1000, 4000);
        repeat(ghc, ghc.new ThermostatNight(), 2000, 4000);
        repeat(ghc, ghc.new LightOn(), 200, 4000);
        repeat(ghc, ghc.new LightOff(), 400, 4000);
        repeat(ghc, ghc.new WaterOn(), 600, 4000);
        repeat(ghc, ghc.new WaterOff(), 800, 4000);
        repeat(ghc, ghc.new ThermostatDay(), 1400, 4000);
        repeat(ghc, ghc.new CollectData(), 500, 4000);
        ghc.tasks.put(ghc.new StopController(5000, exec));
        exec.execute(new GreenhouseController.GreenhouseGo(ghc.tasks));
    }

    public static void repeat(GreenhouseController controller, DelayedGreenhouseTask task, long interval, long duration) {
        if (interval <= duration) {
            for (long i = 0; i < duration / interval; i++) {
                DelayedGreenhouseTask t = task.create(interval * (i + 1));
                controller.tasks.put(t);
            }
        }
    }
}
