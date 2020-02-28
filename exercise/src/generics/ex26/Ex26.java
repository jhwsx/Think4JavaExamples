package generics.ex26;

/**
 * Demonstrate array covariance using Numbers and Integers.
 *
 * @author wangzhichao
 * @since 2019/12/25
 */
public class Ex26 {
    public static void main(String[] args) {
        Number[] numbers = new Integer[10];
        numbers[0] = 1;
        Number number = numbers[0];
        System.out.println(number.getClass());
        System.out.println(number);

        try {
            numbers[0] = new Short("2");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
