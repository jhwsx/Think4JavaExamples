package polymorphism._05;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Cycle {
    public void travel() {
        System.out.println("Cycle.travel()");
    }

    public int wheels() {
        return 0;
    }
}

class Unicycle extends Cycle {
    @Override
    public void travel() {
        System.out.println("Unicycle.travel()");
    }

    @Override
    public int wheels() {
        return 1;
    }
}

class Bicycle extends Cycle {
    @Override
    public void travel() {
        System.out.println("Bicycle.travel()");
    }

    @Override
    public int wheels() {
        return 2;
    }
}

class Tricycle extends Cycle {
    @Override
    public void travel() {
        System.out.println("Tricycle.travel()");
    }

    @Override
    public int wheels() {
        return 3;
    }
}

public class Biking {
    public static void ride(Cycle cycle) {
        cycle.travel();
        System.out.println(cycle.wheels());
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
