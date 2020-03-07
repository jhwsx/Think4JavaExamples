package concurrency.ex09;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
    private int newPriority;

    public PriorityThreadFactory(int newPriority) {
        this.newPriority = newPriority;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(newPriority);
        return t;
    }
}