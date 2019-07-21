package initialization._15;

/**
 * @author wzc
 * @date 2019/6/10
 */
public class Cars {
    public static void main(String[] args) {
        new Car();
    }
}
class Car {
    String s;
    {
        s = "good car";
        System.out.println("s initialized");
    }
    Car() {
        System.out.println("Car()");
    }
}
