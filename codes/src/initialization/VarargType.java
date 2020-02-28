package initialization;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class VarargType {
    static void f(Character... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    static void e(Byte...args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    static void d(byte... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }
    static void g(int... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    static void h(double... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    static void h(boolean... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }
    public static void main(String[] args) {
        d((byte)2);
        e((byte)1);
        f('a');
        f();
        g(1);
        g();
        h(1.1);
        h(true,false);
        System.out.println("int[]: " + new int[0].getClass());
    }
}
