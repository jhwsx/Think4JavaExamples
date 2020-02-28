package reusing;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class SprinklerSystem {
    private String valve1, valve2,valve3,valve4;
    private WaterSource source = new WaterSource();
    private int mInt;
    private float mFloat;

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "valve1='" + valve1 + '\'' +
                ", valve2='" + valve2 + '\'' +
                ", valve3='" + valve3 + '\'' +
                ", valve4='" + valve4 + '\'' +
                ", source=" + source +
                ", mInt=" + mInt +
                ", mFloat=" + mFloat +
                '}';
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }
}

class WaterSource {
    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}
