package innerclasses;

/**
 * 内部类可以被覆盖吗？不存在覆盖问题，两个内部类是完全独立的个体
 * @author wzc
 * @date 2019/7/28
 */
class Egg {
    private Yolk y;
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk");
        }
    }
    public Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}

public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }
    public static void main(String[] args) {
        new BigEgg();
    }
}
