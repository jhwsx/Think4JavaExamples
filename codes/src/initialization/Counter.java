package initialization;

/**
 * @author wzc
 * @date 2019/6/5
 */
public class Counter {
    int mInt;

    public Counter() {
        System.out.println("构造初始化前：mInt = " + mInt);
        mInt = 7;
        System.out.println("构造初始化后：mInt = " + mInt);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
    }
}
