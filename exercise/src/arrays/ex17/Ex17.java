package arrays.ex17;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author wzc
 * @date 2020/2/3
 */
class BigDecimalGenerator implements Generator<BigDecimal> {
    private BigDecimal bd = new BigDecimal(0.0);
    @Override
    public BigDecimal next() {
        return bd.add(new BigDecimal(1.0));
    }
}
public class Ex17 {
    public static void main(String[] args) {
        BigDecimal[] bda1 = new BigDecimal[4];
        Generated.array(bda1, new BigDecimalGenerator());
        System.out.println(Arrays.toString(bda1));
        BigDecimal[] bda2 = Generated.array(BigDecimal.class, new BigDecimalGenerator(), 5);
        System.out.println(Arrays.toString(bda2));

    }
}
