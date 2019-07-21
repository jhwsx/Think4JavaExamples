package initialization._10;

/**
 * @author wzc
 * @date 2019/5/31
 */
public class TerminationConditionEx {
    public static void main(String[] args) {
        MobileBank mobileBank1 = new MobileBank(true);
        MobileBank mobileBank2 = new MobileBank(true);
        mobileBank1.logout();
        mobileBank2.logout();

        new MobileBank(true);
        System.gc();
    }
}
