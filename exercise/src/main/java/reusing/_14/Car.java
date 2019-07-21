package reusing._14;

/**
 * @author wzc
 * @date 2019/7/12
 */
class Engine {
    public void start() {

    }
    public void rev() {

    }
    public void stop() {

    }

    public void service() {
        System.out.println("Engine.service()");
    }
}

class Wheel {
    public void inflate(int psi) {

    }
}

class Window {
    public void rollup() {

    }
    public void rolldown() {

    }
}

class Door {
    public Window mWindow = new Window();
    public void open() {

    }

    public void close() {

    }
}

public class Car {
    public Engine mEngine = new Engine();
    public Wheel[] mWheels = new Wheel[4];
    public Door left = new Door(), right = new Door();
    public Car() {
        for (int i = 0; i < 4; i++) {
            mWheels[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.mWindow.rollup();
        car.right.mWindow.rolldown();
        car.mWheels[0].inflate(72);
        car.mEngine.service();
    }
}
