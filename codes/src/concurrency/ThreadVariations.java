package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 线程的变形
 * // 使用命名的内部类
 * // 使用匿名内部类
 * // 使用命名的 Runnable 实现
 * // 使用匿名的 Runnable 实现
 * // 运行一些代码为任务的单独的方法
 *
 * @author wangzhichao
 * @since 2020/3/6
 */
// 使用命名的内部类
class InnerThread1 {
    private int countDown = 5;

    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        @Override
        public String toString() {
            return getName() + "(" + countDown + ")";
        }
    }

    public InnerThread1(String name) {
        new Inner(name);
    }
}

// 使用匿名内部类
class InnerThread2 {
    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }

            @Override
            public String toString() {
                return getName() + "(" + countDown + ")";
            }
        };
        t.start();
    }
}

// 使用命名的 Runnable 实现
class InnerRunnable1 {
    private int countDown = 5;

    private class Inner implements Runnable {
        private Thread t;
        public Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        @Override
        public String toString() {
            return t.getName() + "(" + countDown + ")";
        }
    }

    public InnerRunnable1(String name) {
        new Inner(name);
    }
}

// 使用匿名的 Runnable 实现
class InnerRunnable2 {
    private Runnable r;
    private int countDown = 5;
    public InnerRunnable2(String name) {
        r = new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName() + "(" + countDown + ")";
            }
        };
        new Thread(r, name).start();
    }
}

// 运行一些代码为任务的单独的方法
class ThreadMethod {
    private int countDown = 5;
    private Thread t = null;
    public void runTask(String name) {
        if (t == null) {
            t = new Thread(name) {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) {
                                return;
                            }
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                }

                @Override
                public String toString() {
                    return Thread.currentThread().getName() + "(" + countDown + ")";
                }
            };
            t.start();
        }
    }
}
public class ThreadVariations {

    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod().runTask("ThreadMethod");
    }
}
