package innerclasses.ex19;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   : 嵌套类与内部类编译出的.class 名字，没有差别
 *     version: 1.0
 * </pre>
 */
public class Ex19 {
    public Ex19() {
        System.out.println("Ex19()");
    }

    class Inner {
        public Inner() {
            System.out.println("Inner()");
        }

        class InnerInner {
            public InnerInner() {
                System.out.println("InnerInner()");
            }
        }
    }

    static class Nest {
        public Nest() {
            System.out.println("Nest()");
        }

        static class NestNest {
            public NestNest() {
                System.out.println("NestNest()");
            }
        }
    }

    public static void main(String[] args) {
        Ex19 ex19 = new Ex19();
        Inner inner = ex19.new Inner();
        Inner.InnerInner innerInner = inner.new InnerInner();
        Nest.NestNest nestNest = new Nest.NestNest();
    }
}

/*
Ex19$Inner$InnerInner.class
Ex19$Inner.class
Ex19$Nest$NestNest.class
Ex19$Nest.class
 */
