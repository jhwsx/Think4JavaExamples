package strings;

/**
 * @author wangzhichao
 * @date 2019/09/21
 */
public class Rudolph {
    public static void main(String[] args) {
        for (String pattern : new String[]{"Rudolph",
                "[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*"}) {
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
