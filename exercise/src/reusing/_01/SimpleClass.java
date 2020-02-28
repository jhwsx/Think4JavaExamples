package reusing._01;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class SimpleClass {
    private String mString;
    public SimpleClass() {
        System.out.println("SimpleClass()");
        mString = "too young, too simple";
    }

    @Override
    public String toString() {
        return mString;
    }
}
