package strings;

/**
 * @author wangzhichao
 * @date 2019/09/21
 */
public class Replacing {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s);

        System.out.println(s.replaceFirst("f\\w+", "located")); // 把首次出现的 以 f 开头的一个或多个单词字符，替换为 located

        System.out.println(s.replaceAll("shrubbery|tree|herring", "banana")); // |表示或，X|Y X 或 Y
    }
}
