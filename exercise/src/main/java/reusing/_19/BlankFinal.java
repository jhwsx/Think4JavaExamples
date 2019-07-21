package reusing._19;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Value {
    private int i;
    public Value(int i) {
        this.i = i;
    }
}
public class BlankFinal {
    private final Value value;

    public BlankFinal() {
        value = new Value(1);
    }

    public BlankFinal(int i) {
        value = new Value(i);
    }

    public static void main(String[] args) {
        BlankFinal blankFinal1 = new BlankFinal();
//        blankFinal1.value = new Value(3);
    }
}
