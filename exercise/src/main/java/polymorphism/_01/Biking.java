package polymorphism._01;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Cycle {
    public void travel() {
        System.out.println("Cycle.travel()");
    }
}

class Unicycle extends Cycle {
    @Override
    public void travel() {
        System.out.println("Unicycle.travel()");
    }
}

class Bicycle extends Cycle {
    @Override
    public void travel() {
        System.out.println("Bicycle.travel()");
    }
}

class Tricycle extends Cycle {
    @Override
    public void travel() {
        System.out.println("Tricycle.travel()");
    }
}

public class Biking {
    public static void ride(Cycle cycle) {
        cycle.travel();
    }
    public static void main(String[] args) {
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        ride(unicycle);
        ride(bicycle);
        ride(tricycle);
    }
}
