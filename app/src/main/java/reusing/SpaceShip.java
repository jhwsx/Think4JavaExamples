package reusing;

/**
 * @author wzc
 * @date 2019/6/17
 */
public class SpaceShip extends SpaceShipControls {
    private String name;

    private SpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }
}
