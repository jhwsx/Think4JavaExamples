package access._06;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class Test {
    public static void main(String[] args) {
        Class1 class1 = new Class1();
        System.out.println(class1.mCompany);

        Class1Helper.change(class1, "abup");
        System.out.println(class1.mCompany);
    }
}
