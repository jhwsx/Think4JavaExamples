package interfaces.interfaceprocessor;

import java.util.Arrays;

/**
 * @author wzc
 * @date 2019/7/18
 */
public abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    public static String s = "If she weighs the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new UpCase(), s);
        Apply.process(new DownCase(), s);
        Apply.process(new Splitter(), s);
    }
}

class UpCase extends StringProcessor {
    @Override
    public Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class DownCase extends StringProcessor {
    @Override
    public Object process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}



