package concurrency.ex29;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzhichao
 * @since 2021/4/8
 */
class Toast {
    public enum Status {DRY, PEANUT_BUTTERED, JELLIED}

    private Status status = Status.DRY;
    private final int id;

    public Toast(int idn) {
        this.id = idn;
    }

    public void peanutButter() {
        status = Status.PEANUT_BUTTERED;
    }

    public void jelly() {
        status = Status.JELLIED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {
}

/**
 * 制作吐司的任务
 */
class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                // 制作 Toast
                Toast toast = new Toast(count++);
                System.out.println(toast);
                // 插入队列
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}

/**
 * 给吐司涂花生黄油的任务
 */
class PeanutButterer implements Runnable {
    private ToastQueue dryQueue;
    private ToastQueue peanutButteredQueue;

    public PeanutButterer(ToastQueue dryQueue, ToastQueue peanutButteredQueue) {
        this.dryQueue = dryQueue;
        this.peanutButteredQueue = peanutButteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 阻塞在这里直到下一片吐司可用为止
                Toast t = dryQueue.take();
                t.peanutButter();
                System.out.println(t);
                peanutButteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("PeanutButterer interrupted");
        }
        System.out.println("PeanutButterer off");
    }
}

/**
 * 在吐司上涂果冻的任务
 */
class Jellyer implements Runnable {
    private ToastQueue dryQueue;
    private ToastQueue jellyQueue;

    public Jellyer(ToastQueue dryQueue, ToastQueue jellyQueue) {
        this.dryQueue = dryQueue;
        this.jellyQueue = jellyQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 阻塞在这里直到下一片吐司可用为止
                Toast t = dryQueue.take();
                t.jelly();
                System.out.println(t);
                jellyQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Jellyer interrupted");
        }
        System.out.println("Jellyer off");
    }
}

class Sandwich {
    private Toast top;
    private Toast bottom;
    private final int id;

    public Sandwich(Toast top, Toast bottom, int id) {
        this.top = top;
        this.bottom = bottom;
        this.id = id;
    }

    public Toast getTop() {
        return top;
    }

    public Toast getBottom() {
        return bottom;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sandwich " + id + ": top: " + top + " and bottom: " + bottom;
    }
}

class SandwichQueue extends LinkedBlockingQueue<Sandwich> {
}

/**
 * 把涂有花生黄油的吐司和涂有果冻的吐司放在一起做成三明治的任务
 */
class SandwichMaker implements Runnable {

    private ToastQueue peanutButteredQueue;
    private ToastQueue jelliedQueue;
    private SandwichQueue sandwichQueue;
    private int count = 0;

    public SandwichMaker(ToastQueue peanutButteredQueue, ToastQueue jelliedQueue, SandwichQueue sandwichQueue) {
        this.peanutButteredQueue = peanutButteredQueue;
        this.jelliedQueue = jelliedQueue;
        this.sandwichQueue = sandwichQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Sandwich sandwich = new Sandwich(peanutButteredQueue.take(), jelliedQueue.take(), count++);
                System.out.println(sandwich);
                sandwichQueue.put(sandwich);
            }
        } catch (InterruptedException e) {
            System.out.println("SandwichMaker interrupted");
        }
        System.out.println("SandwichMaker off");
    }
}

/**
 * 消费三明治的任务
 */
class SandwichEater implements Runnable {
    private SandwichQueue sandwichQueue;
    private int counter = 0;
    public SandwichEater(SandwichQueue sandwichQueue) {
        this.sandwichQueue = sandwichQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Sandwich s = sandwichQueue.take();
                if (s.getId() != counter++ ||
                s.getTop().getStatus() != Toast.Status.PEANUT_BUTTERED ||
                s.getBottom().getStatus() != Toast.Status.JELLIED) {
                    System.out.println(">>>> Error: " + s);
                    System.exit(1);
                } else {
                    System.out.println("NumNum! " + s);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("SandwichEater interrupted");
        }
        System.out.println("SandwichEater off");
    }
}

public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ToastQueue dryQueue = new ToastQueue();
        ToastQueue peanutButteredQueue = new ToastQueue();
        ToastQueue jelliedQueue = new ToastQueue();
        SandwichQueue sandwichQueue = new SandwichQueue();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new PeanutButterer(dryQueue, peanutButteredQueue));
        exec.execute(new Jellyer(dryQueue, jelliedQueue));
        exec.execute(new SandwichMaker(peanutButteredQueue, jelliedQueue, sandwichQueue));
        exec.execute(new SandwichEater(sandwichQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
