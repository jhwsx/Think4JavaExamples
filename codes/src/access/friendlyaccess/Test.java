package access.friendlyaccess;

/**
 * @author wzc
 * @date 2019/6/14
 */
public class Test {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        System.out.println(classA.mProtectedField);
        System.out.println(classA.mField);
    }
}
