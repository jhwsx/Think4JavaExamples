package generics.ex36;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2020/01/06
 */
// 一个具有 process() 方法的接口，process() 方法可能抛出具有类型 E 的异常。
// 处理后的结果储存在 List<T> resultCollector 中，这叫收集参数。
interface Processor<T, E extends Exception, E2 extends Exception> {
    void process(List<T> resultCollector) throws E, E2;
}

// 这是一个自定义的集合
class ProcessRunner<T, E extends Exception, E2 extends Exception>
        extends ArrayList<Processor<T, E, E2>> {
    List<T> processAll() throws E, E2 {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E, E2> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception {
}

// 处理器1
class Processor1 implements Processor<String, Failure1, Failure3> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1, Failure3 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }
        if (count < 0) {
            throw new Failure1();
        }
        if (count < -1) {
            throw new Failure3();
        }
    }
}

class Processor1b implements Processor<String, Failure1, Failure3> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1, Failure3 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }
        if (count < 0) {
            throw new Failure1();
        }
        if (count == 1) {
            throw new Failure3();
        }
    }
}

class Failure2 extends Exception {
}

class Failure3 extends Exception {
}

// 处理器2
class Processor2 implements Processor<Integer, Failure2, Failure3> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure2, Failure3 {
        if (count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0) {
            throw new Failure2();
        }
        if (count < -1) {
            throw new Failure3();
        }
    }
}

class Processor2b implements Processor<Integer, Failure2, Failure3> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure2, Failure3 {
        if (count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0) {
            throw new Failure2();
        }
        if (count == 1) {
            throw new Failure3();
        }
    }
}

public class ThrowGenericException {
    public static void main(String[] args) {
        System.out.println("1:");
        ProcessRunner<String, Failure1, Failure3> runner =
                new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }
        try {
            System.out.println(runner.processAll());
        } catch (Failure1 failure1) {
            System.out.println(failure1);
        } catch (Failure3 failure3) {
            System.out.println(failure3);
        }
        System.out.println("2:");
        ProcessRunner<String, Failure1, Failure3> runnerb =
                new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runnerb.add(new Processor1b());
        }
        try {
            System.out.println(runnerb.processAll());
        } catch (Failure1 failure1) {
            System.out.println(failure1);
        } catch (Failure3 failure3) {
            System.out.println(failure3);
        }

        System.out.println("3:");
        ProcessRunner<Integer, Failure2, Failure3> runner2 =
                new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 failure2) {
            System.out.println(failure2);
        } catch (Failure3 failure3) {
            System.out.println(failure3);
        }

        System.out.println("4:");
        ProcessRunner<Integer, Failure2, Failure3> runner2b =
                new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2b.add(new Processor2b());
        }
        try {
            System.out.println(runner2b.processAll());
        } catch (Failure2 failure2) {
            System.out.println(failure2);
        } catch (Failure3 failure3) {
            System.out.println(failure3);
        }
    }
}
