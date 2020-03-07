package concurrency.ex04;

import concurrency.ex02.Fibonacci;

class FibonacciRunnable implements Runnable {
    private int count = 0;

    public FibonacciRunnable(int count) {
        this.count = count;
    }

    @Override
    public void run() {
//        System.out.println("start: " + count);
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < count; i++) {
            System.out.print(gen.next() + " ");
        }
        System.out.println();
//        System.out.println("end: " + count);
    }
}