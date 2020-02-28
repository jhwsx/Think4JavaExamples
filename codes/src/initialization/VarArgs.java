package initialization;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class VarArgs {
    static void printArray(Object[] args) {
        for (Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        printArray(); // 必须传参
        printArray(new Object[]{new Integer(47), new Float(3.14f), new Double(11.12)});
        printArray(new Object[]{"yi","er","san"});
        printArray(new Object[]{new A(),new A(),new A()});
        printArray(new A[]{new A(),new A(),new A()});
    }
}

class A {}
