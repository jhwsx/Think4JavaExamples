package reusing;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Poppet {
    private int i;

    Poppet(int i) {
        this.i = i;
    }
}
public class BlankFinal {
    private final int i = 0; // 在域的定义处初始化 final
    private final int j; // 空白 final
    private final Poppet p;
    public BlankFinal() {
        j = 1;
        p = new Poppet(1);
    }

    public BlankFinal(int i) {
        j = i;
        p = new Poppet(i);
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
