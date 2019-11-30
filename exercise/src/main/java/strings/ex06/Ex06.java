package strings.ex06;

import androidx.annotation.NonNull;

/**
 * @author wangzhichao
 * @date 2019/09/07
 */
public class Ex06 {
    int x = 100;
    long y = 19999999999L;
    float f = 0.55f;
    double d = 2.14444;

    @NonNull
    @Override
    public String toString() {
        return String.format("x = %d, y = %d, f = %f, d = %f", x, y, f, d);
    }

    public static void main(String[] args) {
        Ex06 ex06 = new Ex06();
        System.out.println(ex06);
    }
}
