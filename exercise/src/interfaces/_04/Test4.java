package interfaces._04;

/**
 * @author wzc
 * @date 2019/7/16
 */
abstract class AbstractClass {

}

class ClassA extends AbstractClass {
    void show() {
        System.out.println("ClassA");
    }
}

abstract class BaseClass {
    abstract void show();
}

class ClassB extends BaseClass {

    @Override
    void show() {
        System.out.println("ClassB");
    }
}
public class Test4 {
    static void testShow(AbstractClass abstractClass) {
        ((ClassA) abstractClass).show();
    }

    static void testShow(BaseClass baseClass) {
        baseClass.show();
    }
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        testShow(classA);
        ClassB classB = new ClassB();
        testShow(classB);
    }
}
