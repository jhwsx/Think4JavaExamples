package holding.ex27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Command {
    private String value;

    Command(String v) {
        this.value = v;
    }

    void operation() {
        System.out.println("Command, value=" + value);
    }
}


class Class2 {
    public Queue<Command> getQueue() {
        return queue;
    }

    private Queue<Command> queue = new LinkedList<>();

    Command add(Command command) {
        queue.add(command);
        return command;
    }
}

class Class3 {
    void consume(Queue<Command> queue) {
        while (queue.peek() != null) {
            Command remove = queue.remove();
            remove.operation();
        }
    }
}
public class Ex27 {
    public static void main(String[] args) {
        Class2 class2 = new Class2();
        class2.add(new Command("1"));
        class2.add(new Command("2"));
        class2.add(new Command("3"));
        class2.add(new Command("4"));
        Class3 class3 = new Class3();
        class3.consume(class2.getQueue());
    }
}
