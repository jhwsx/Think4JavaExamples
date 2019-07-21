package polymorphism._12;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Value {
    Value(String s) {
        System.out.println("Value(), s = " + s);
    }
}
class Rodent {
    private Value value = new Value("Rodent");
    Rodent() {
        System.out.println("Rodent()");
    }
    void eat() {
        System.out.println("Rodent.eat()");
    }
    void sleep() {
        System.out.println("Rodent.sleep()");
    }
}

class Mouse extends Rodent {
    private Value value = new Value("Mouse");
    Mouse() {
        System.out.println("Mouse()");
    }
    @Override
    void eat() {
        System.out.println("Mouse.eat()");
    }

    @Override
    void sleep() {
        System.out.println("Mouse.sleep()");
    }
}

class Gerbil extends Rodent {
    Gerbil() {
        System.out.println("Gerbil()");
    }
    @Override
    void eat() {
        System.out.println("Gerbil.eat()");
    }

    @Override
    void sleep() {
        System.out.println("Gerbil.sleep()");
    }
}

class Hamster extends Rodent {
    Hamster() {
        System.out.println("Hamster()");
    }
    @Override
    void eat() {
        System.out.println("Hamster.eat()");
    }

    @Override
    void sleep() {
        System.out.println("Hamster.sleep()");
    }
}

public class Animal {
    public static void main(String[] args) {
        Rodent[] rodents = {
                new Mouse(),
                new Gerbil(),
                new Hamster()
        };
        showAll(rodents);
    }

    public static void showAll(Rodent[] rodents) {
        for (Rodent rodent : rodents) {
            show(rodent);
        }
    }

    public static void show(Rodent rodent) {
        rodent.eat();
        rodent.sleep();
    }
}
