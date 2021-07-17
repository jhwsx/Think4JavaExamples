package io.ex11.controller;


import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/28
 *     desc   : 用来管理和触发事件的实际控制框架
 *     version: 1.0
 * </pre>
 */
public class Controller {
    // 事件被保存在 List 集合里面
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
            // 思考一下：这里为什么要对 eventList 做一个拷贝呢？
            // 答：在遍历集合的过程中不能修改它，否则会产生并发修改异常。
            for (Event event : new ArrayList<Event>(eventList)) {
                // 找到就绪的事件
                if (event.ready()) {
                    // 打印这个事件
                    System.out.println(event);
                    // 执行这个事件的 action 方法
                    event.action();
                    eventList.remove(event);
                }
            }
        }
    }
}
