package annotations.ex02;

/**
 * @author wangzhichao
 * @since 2020/5/15
 */
@ExtractInterface(interfaceName = "IDivider")
public class Divider {
    public int divider(int x, int y) throws ArithmeticException {
        if (y == 0) {
            throw new ArithmeticException("the divisor cannot be 0");
        }
        int diff = subtract(x, y);
        if (diff < 0) {
            return 0;
        }
        if (diff == 0) {
            return 1;
        }
        int result = 0;
        while (diff >= 0) {
            result++;
            diff = subtract(diff, y);
        }
        return result;
    }

    private int subtract(int x, int y) {
        return x - y;
    }

    public static void main(String[] args) {
        Divider divider = new Divider();
        System.out.println("11 / 16 = " + divider.divider(11, 16));
        System.out.println("15 / 5 = " + divider.divider(15, 5));
        System.out.println("10 / 3 = " + divider.divider(10, 3));
        System.out.println("10 / 10 = " + divider.divider(10, 10));
        System.out.println("1 / 0 = " + divider.divider(1, 0));
    }
}
