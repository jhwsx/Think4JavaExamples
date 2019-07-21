package reusing._01;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class SecondClass {
    private SimpleClass mSimpleClass;

    @Override
    public String toString() {
        if (mSimpleClass == null) {
            System.out.println("lazy init");
            mSimpleClass = new SimpleClass();
        }
        return "SecondClass{" +
                "mSimpleClass=" + mSimpleClass +
                '}';
    }

    public static void main(String[] args) {
        SecondClass secondClass = new SecondClass();
        System.out.println(secondClass);
    }
}
