package generics;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangzhichao
 * @since 2019/12/09
 */

class ConsumingTask extends Thread {

    interface Callback {
        void onFinished();
    }

    public void setCb(Callback cb) {
        this.cb = cb;
    }

    private Callback cb;
    @Override
    public void run() {
        super.run();
        System.out.println("ConsumingTask start: " + System.currentTimeMillis());
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ConsumingTask end: " + System.currentTimeMillis());
        cb.onFinished();
    }
}

public class LimitsOfInference {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ConsumingTask consumingTask = new ConsumingTask();
        consumingTask.setCb(new ConsumingTask.Callback() {
            @Override
            public void onFinished() {
                countDownLatch.countDown();
            }
        });
        consumingTask.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}
