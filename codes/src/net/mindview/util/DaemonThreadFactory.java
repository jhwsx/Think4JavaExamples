//: net/net.net.mindview/util/DaemonThreadFactory.java
package net.mindview.util;

import java.util.concurrent.*;

// 设置后台线程
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
} ///:~
