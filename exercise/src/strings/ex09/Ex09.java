package strings.ex09;

/**
 * @author wangzhichao
 * @date 2019/09/21
 */
public class Ex09 {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void main(String[] args) {
        System.out.println(knights.replaceAll("[aeiouAEIOU]", "_"));
    }
}
