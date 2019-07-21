package initialization;

/**
 * @author wzc
 * @date 2019/6/5
 */
public class Spoon {
    static int i;
    static {
        i = 47;
    }

    public static void main(String[] args) {
        System.out.println(i);
    }
}
