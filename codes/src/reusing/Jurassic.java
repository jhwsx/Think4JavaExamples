package reusing;

/**
 * @author wzc
 * @date 2019/7/13
 */
class SmallBrain {

}

final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain sb = new SmallBrain();
    void f() {

    }
}

//class Further extends Dinosaur {
//
//}
public class Jurassic {
    public static void main(String[] args) {
        Dinosaur dinosaur = new Dinosaur();
        dinosaur.f();
        dinosaur.i = 40;
        dinosaur.j++;
    }
}
