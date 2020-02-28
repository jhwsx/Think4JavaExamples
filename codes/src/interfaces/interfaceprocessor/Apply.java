package interfaces.interfaceprocessor;

/**
 * @author wzc
 * @date 2019/7/18
 */
public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
