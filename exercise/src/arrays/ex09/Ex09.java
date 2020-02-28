package arrays.ex09;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wzc
 * @date 2020/1/30
 */
/* Create the classes necessary for the Peel<Banana> example and
 * show that the compiler doesn't accept it. Fix the problem
 * using an ArrayList.
 * */
class Banana {
    private static long counter;
    private final long id = counter;

    @Override
    public String toString() {
        return " Banana " + id;
    }
}

class Peel<T> {
    private T t;
    private static long counter;
    private final long id = counter;

    public Peel(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Peel " + id + t.toString();
    }
}

public class Ex09<T> {
    public static void main(String[] args) {
        // 编译报错：generic array creation
//        Peel<Banana>[] peels = new Peel<Banana>[10];
        List<Peel<Banana>> peels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            peels.add(new Peel<Banana>(new Banana()));
        }
        System.out.println(peels);
        System.out.println("peels.get(0).getClass() = " + peels.get(0).getClass());
    }
}
