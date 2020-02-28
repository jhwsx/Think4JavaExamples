package generics.ex27;


import java.util.ArrayList;
import java.util.List;

/**
 * Show that covariance doesn't work with Lists using Numbers and
 * Integers, then introduce wildcards.
 *
 * @author wangzhichao
 * @since 2019/12/25
 */
public class Ex27 {
    public static void main(String[] args) {
        // 编译不通过了：类型不兼容：需要是List<Number>,但发现的却是ArrayList<Integer>
        // 理解为：不能把一个涉及 Integer 的泛型赋给一个涉及 Number 的泛型。
//        List<Number> numberList = new ArrayList<Integer>();

        List<? extends Number> numbers = new ArrayList<Integer>();
//        numbers.add(2);

        Number number = numbers.get(0);
    }
}
