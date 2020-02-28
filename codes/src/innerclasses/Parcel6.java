package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/24
 *     desc   : 嵌套一个类在作用域中
 *     version: 1.0
 * </pre>
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }

            TrackingSlip ts = new TrackingSlip("slip");
            String slip = ts.getSlip();
            System.out.println(slip);
        }
//        new TrackingSlip("x"); // 不可以在作用域之外使用，编译不通过
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 p  = new Parcel6();
        p.track();
    }
}
