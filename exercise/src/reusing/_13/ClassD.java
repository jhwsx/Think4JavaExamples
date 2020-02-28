package reusing._13;

/**
 * @author wzc
 * @date 2019/7/12
 */
class ClassA {
    void method(boolean b) {
        System.out.println("method(boolean)");
    }
}

class ClassB extends ClassA {
    void method(float b) {
        System.out.println("method(float)");
    }
}

class ClassC extends ClassB {
    void method(String s) {
        System.out.println("method(String)");
    }
}


public class ClassD extends ClassC {
    void method(char c) {
        System.out.println("method(char)");
    }

    public static void main(String[] args) {
        ClassD classD = new ClassD();
        classD.method('a');
        classD.method(1f);
        classD.method("hello");
        classD.method(false);
    }
}
