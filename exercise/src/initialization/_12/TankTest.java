package initialization._12;

/**
 * @author wzc
 * @date 2019/5/31
 */
public class TankTest {
    public static void main(String[] args) {
        Tank tank1 = new Tank(true);
        tank1.empty();

        new Tank(true);

        System.gc();
    }
}
