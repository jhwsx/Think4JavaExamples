package strings.ex05;

import java.util.Formatter;

/**
 * @author wangzhichao
 * @date 2019/09/07
 */
public class Ex05 {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);

        char u = 'a';
        f.format("%-2s%-2S%-2c%-2C%-5b%-5B%-3h%-3H%%", u, u, u, u, u, u, u, u);
    }
}
