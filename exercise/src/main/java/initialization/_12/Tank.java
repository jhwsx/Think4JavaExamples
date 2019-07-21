package initialization._12;

/**
 * @author wzc
 * @date 2019/5/31
 */
public class Tank {
    boolean filled;

    public Tank(boolean fill) {
        filled = fill;
    }

    public void empty() {
        filled = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (filled) {
            System.out.println("Error: still filled");
        }
//        super.finalize();
    }
}
