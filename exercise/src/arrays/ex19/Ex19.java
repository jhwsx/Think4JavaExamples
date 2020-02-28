package arrays.ex19;

import java.util.Arrays;

/**
 * @author wzc
 * @date 2020/2/6
 */
class A {
    private int x;
    A(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        A a = (A) o;
        return x == a.x;
    }

}
public class Ex19 {
    public static void main(String[] args) {
        A[] a1 = new A[2];
        a1[0] = new A(1);
        a1[1] = new A(2);
        A[] a2 = {new A(1), new A(2)};
        System.out.println(Arrays.equals(a1, a2));
        A[] a3 = {new A(2), new A(1)};
        System.out.println(Arrays.equals(a1, a3));

    }
}
