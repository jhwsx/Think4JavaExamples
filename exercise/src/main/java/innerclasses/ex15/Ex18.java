package innerclasses.ex15;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   : 修改为匿名内部类
 *     version: 1.0
 * </pre>
 */
interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {

    private Unicycle() {
    }

    @Override
    public void ride() {
        System.out.println("Unicycle.ride()");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}

//class UnicycleFactory implements CycleFactory {
//
//    @Override
//    public Cycle getCycle() {
//        return new Unicycle();
//    }
//}

class Bicycle implements Cycle {
    private Bicycle() {

    }
    @Override
    public void ride() {
        System.out.println("Bicycle.ride()");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}

//class BicycleFactory implements CycleFactory {
//
//    @Override
//    public Cycle getCycle() {
//        return new Bicycle();
//    }
//}

class Tricycle implements Cycle {
    private Tricycle() {

    }
    @Override
    public void ride() {
        System.out.println("Tricycle.ride()");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}

//class TricycleFactory implements CycleFactory {
//
//    @Override
//    public Cycle getCycle() {
//        return new Tricycle();
//    }
//}

public class Ex18 {
    public static void rideCycle(CycleFactory cycleFactory) {
        Cycle cycle = cycleFactory.getCycle();
        cycle.ride();
    }

    public static void main(String[] args) {
//        rideCycle(new UnicycleFactory());
//        rideCycle(new BicycleFactory());
//        rideCycle(new TricycleFactory());
        rideCycle(Unicycle.factory);
        rideCycle(Bicycle.factory);
        rideCycle(Tricycle.factory);
    }

}
