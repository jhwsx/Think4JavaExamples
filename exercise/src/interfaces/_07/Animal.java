package interfaces._07;

/**
 * @author wzc
 * @date 2019/7/13
 */
interface Rodent {
    void eat();

    void sleep();
}

class Mouse implements Rodent {
    @Override
    public void eat() {
        System.out.println("Mouse.eat()");
    }

    @Override
    public void sleep() {
        System.out.println("Mouse.sleep()");
    }
}

class Gerbil implements Rodent {
    @Override
    public void eat() {
        System.out.println("Gerbil.eat()");
    }

    @Override
    public void sleep() {
        System.out.println("Gerbil.sleep()");
    }
}

class Hamster implements Rodent {
    @Override
    public void eat() {
        System.out.println("Hamster.eat()");
    }

    @Override
    public void sleep() {
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
