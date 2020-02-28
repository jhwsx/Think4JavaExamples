package interfaces._03;

/**
 * @author wzc
 * @date 2019/7/16
 */
abstract class BaseClass {
    BaseClass() {
        print();
    }
    abstract void print();
}
public class ClassA extends BaseClass{
    private int i = 5;
    @Override
    void print() {
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.print();
    }
}
