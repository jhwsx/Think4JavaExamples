package interfaces.interfaceprocessor;

/**
 * @author wzc
 * @date 2019/7/18
 */
public interface Processor {
    String name();
    Object process(Object input);
}
