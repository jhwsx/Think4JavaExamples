package interfaces._08;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Meal {
    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheesse()");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

interface Fastfood {
    void cheeseburger();

    void fries();

    void softDrink();
}
public class Sandwich extends PortableLunch implements Fastfood{
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettuce lettuce = new Lettuce();
    private Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich();
        sandwich.cheeseburger();
        sandwich.fries();
        sandwich.softDrink();
    }

    @Override
    public void cheeseburger() {
        System.out.println("CheeseBurger");
    }

    @Override
    public void fries() {
        System.out.println("Fries");
    }

    @Override
    public void softDrink() {
        System.out.println("Soft Drink");
    }
}
