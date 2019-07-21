package initialization;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class NewVarArgs {
    static void printArray(Object... args) {
        System.out.println("args.length=" + args.length+", args="+args);
        for (Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(); // 可以不传参的
        printArray(new Integer(47),new Integer(48),new Float(3.14),new Double(11.11));
        printArray(12,2,3,3,45f);
        printArray("ONE","TWO","THREE");
        printArray(new B(),new B(),new B());
        printArray((Object[]) new Integer[]{1,2,3,4});
    }
}

class B {
}