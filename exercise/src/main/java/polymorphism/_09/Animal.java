package polymorphism._09;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Rodent {
    void eat() {
        System.out.println("Rodent.eat()");
    }
    void sleep() {
        System.out.println("Rodent.sleep()");
    }
}

class Mouse extends Rodent {
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
