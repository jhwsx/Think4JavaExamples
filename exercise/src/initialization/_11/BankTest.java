package initialization._11;

/**
 * @author wzc
 * @date 2019/5/31
 */
public class BankTest {
    public static void main(String[] args) {
        MobileBank mobileBank1 = new MobileBank(true);
        MobileBank mobileBank2 = new MobileBank(true);
        new MobileBank(true);
        mobileBank1.logout();

        System.out.println("Try 1: ");
//        System.runFinalization();
        System.out.println("Try 2: ");
//        Runtime.getRuntime().runFinalization();
        System.out.println("Try 3: ");
//        System.gc();
//        Runtime.getRuntime().gc();
        System.out.println("Try 4: ");
        System.runFinalizersOnExit(true);
    }
}
