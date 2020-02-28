package interfaces.classprocessor;

import java.util.Arrays;

/**
 * 策略设计模式
 * @author wzc
 * @date 2019/7/17
 */
class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
public class Apply {
    public static String s =
            "Disagreement with beliefs is by definition incorrect";

    public static void process(Processor processor, Object o) {
        System.out.println(processor.process(o));
    }
    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}
