package interfaces._15;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Test {
    static void s1(ClassA classA) {
        classA.f();
    }

    static void s2(InterfaceA interfaceA) {
        interfaceA.a1();
        interfaceA.a2();
    }

    static void s3(InterfaceB interfaceB) {
        interfaceB.b1();
        interfaceB.b2();
    }

    static void s4(InterfaceC interfaceC) {
        interfaceC.c1();
        interfaceC.c2();
    }

    static void s5(InterfaceD interfaceD) {
        interfaceD.a1();
        interfaceD.a2();
        interfaceD.b1();
        interfaceD.b2();
        interfaceD.c1();
        interfaceD.c2();
    }

    public static void main(String[] args) {
        ClassB classB = new ClassB();
        s1(classB);
        System.out.println("----------------");
        s2(classB);
        System.out.println("----------------");
        s3(classB);
        System.out.println("----------------");
        s4(classB);
        System.out.println("----------------");
        s5(classB);
    }
}
