package initialization._17;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class Test17 {
    public static void main(String[] args) {
        A[] aArray = new A[5];
        for (int i = 0; i < aArray.length; i++) {
            System.out.println(aArray[i]);
        }
    }
}

class A {
    String s;

    public A(String s) {
        System.out.println("initialize s");
        this.s = s;
    }
}
