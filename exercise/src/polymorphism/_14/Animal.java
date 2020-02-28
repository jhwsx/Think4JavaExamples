package polymorphism._14;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Value {
    Value(String s) {
        System.out.println("Value(), s = " + s);
    }
}

class Shared {
    private int refCount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        refCount++;
    }

    protected void dispose() {
        if (--refCount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Rodent {
    protected Shared shared;
    private Value value = new Value("Rodent");

    Rodent(Shared shared) {
        this.shared = shared;
        this.shared.addRef();
        System.out.println("Rodent()");
    }

    void eat() {
        System.out.println("Rodent.eat()");
    }

    void sleep() {
        System.out.println("Rodent.sleep()");
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Mouse extends Rodent {
    private Value value = new Value("Mouse");

    Mouse(Shared shared) {
        super(shared);
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
    Gerbil(Shared shared) {
        super(shared);
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
    Hamster(Shared shared) {
        super(shared);
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
        Shared shared = new Shared();
        Rodent[] rodents = {
                new Mouse(shared),
                new Gerbil(shared),
                new Hamster(shared)
        };
        showAll(rodents);
        for (int i = rodents.length - 1; i >= 0; i--) {
            rodents[i].dispose();
        }
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
