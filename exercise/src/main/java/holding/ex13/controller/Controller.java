package holding.ex13.controller;


import java.util.LinkedList;
import java.util.ListIterator;

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
//    private List<Event> eventList = new ArrayList<>();
    private LinkedList<Event> eventList = new LinkedList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
//        while (eventList.size() > 0) {
//            for (Event event : new ArrayList<Event>(eventList)) {
//                if (event.ready()) {
//                    System.out.println(event);
//                    event.action();
//                    eventList.remove(event);
//                }
//            }
//        }
        // 错误的写法
//        Iterator<Event> iterator = eventList.iterator();
//        while (iterator.hasNext()) {
//            Event next = iterator.next();
//            if (next.ready()) {
//                System.out.println(next);
//                next.action();
//            }
//        }
        // 正确的写法
        while (eventList.size() > 0) {
        LinkedList<Event> copy = new LinkedList<>(eventList);
        ListIterator<Event> listIterator = copy.listIterator();
            while (listIterator.hasNext()) {
                Event event = listIterator.next();
                if (event.ready()) {
                    System.out.println(event);
                    event.action();
                    eventList.remove(event);
                }
            }
        }

    }
}
