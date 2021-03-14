package concurrency.ex03;

class MyRunnable implements Runnable {
    private int id;

    public MyRunnable(int id) {
        this.id = id;
        System.out.println("MyRunnable " + id + " startup");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            System.out.println("MyRunnable " + id + " task index:" + i);
            Thread.yield();
        }
        System.out.println("MyRunnable " + id + " end");
    }
}