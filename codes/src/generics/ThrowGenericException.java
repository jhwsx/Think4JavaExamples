package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2020/01/06
 */
// 一个具有 process() 方法的接口，process() 方法可能抛出具有类型 E 的异常。
// 处理后的结果储存在 List<T> resultCollector 中，这叫收集参数。
interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

// 这是一个自定义的集合
class ProcessRunner<T, E extends Exception>
        extends ArrayList<Processor<T, E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception {
}

// 处理器1
class Processor1 implements Processor<String, Failure1> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }
        if (count < 0) {
            throw new Failure1();
        }
    }
}

class Failure2 extends Exception {
}

// 处理器2
class Processor2 implements Processor<Integer, Failure2> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if (count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0) {
            throw new Failure2();
        }
    }
}

public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String, Failure1> runner =
                new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }
        try {
            System.out.println(runner.processAll());
        } catch (Failure1 failure1) {
            System.out.println(failure1);
        }

        ProcessRunner<Integer, Failure2> runner2 =
                new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 failure2) {
            System.out.println(failure2);
        }
    }
}
