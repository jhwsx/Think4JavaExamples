package initialization._14;

/**
 * @author wzc
 * @date 2019/6/5
 */
public class StaticTest {
    public static void main(String[] args) {
//        MyClass.print();
        myClass1.print();
    }

    static MyClass myClass1 = new MyClass();
    static MyClass myClass2 = new MyClass();
}

class MyClass {
    static String s1 = "s1";
    static String s2;
    static {
        s2 = "s2";
    }
    static void print() {
        System.out.println("s1 = " + s1 + ", s2 = " + s2);
    }
}
