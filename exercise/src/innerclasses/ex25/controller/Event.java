package innerclasses.ex25.controller;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/28
 *     desc   : 接口描述了要控制的事件。这里默认行为是基于时间去执行控制，所以使用抽象类代替实际的接口
 *     version: 1.0
 * </pre>
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() { // Allows restarting
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() > eventTime;
    }

    public abstract void action();
}
