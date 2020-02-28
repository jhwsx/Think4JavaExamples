package generics;

/**
 * @author wangzhichao
 * @since 2019/12/15
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id() {
        return id;
    }
    public String toString() {
        return "CountedObject " + id;
    }
}
