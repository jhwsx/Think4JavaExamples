package strings;

/**
 * @author wangzhichao
 * @date 2019/09/20
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+")); // -? 表示有一个负号（-）或者没有负号（-），\\d 表示一位数字，+表示一位或多位数字
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+")); // 可能以一个加号或减号开头
    }
}
