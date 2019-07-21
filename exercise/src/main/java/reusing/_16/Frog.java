package reusing._16;

/**
 * @author wzc
 * @date 2019/7/12
 */
class Amphibian {
    protected void swim() {
        System.out.println("Amphibian swim");
    }
    protected void speak() {
        System.out.println("Amphibian speak");
    }
    void eat() {
        System.out.println("Amphibian eat");
    }
    static void display(Amphibian amphibian) {
        System.out.println("Amphibian display");
        amphibian.swim();
        amphibian.speak();
        amphibian.eat();
    }
}

public class Frog extends Amphibian {
    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.swim();
        frog.speak();
        frog.eat();
        Amphibian.display(frog);
    }
}
