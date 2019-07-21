package reusing;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Gizmo {
    public void spin() {

    }
}

public class FinalArguments {
    void with(final Gizmo g) {
//        g = new Gizmo();
    }
    void without(Gizmo g) {
        g = new Gizmo();
        g.spin();
    }

    //    void f(final int i) {
//        i++;
//    }
    int g(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments finalArguments = new FinalArguments();
        finalArguments.with(null);
        finalArguments.without(null);
    }
}
