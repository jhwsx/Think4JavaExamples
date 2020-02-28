package initialization._10;

/**
 * 手机银行
 * @author wzc
 * @date 2019/5/31
 */
public class MobileBank {
    private boolean loggedIn;

    public MobileBank(boolean login) {
        loggedIn = login;
    }

    public void logout() {
        loggedIn = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (loggedIn) {
            System.out.println("Error: still logged in");
        }
//        super.finalize();
    }
}
