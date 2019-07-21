package reusing._18;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Value {
    private int i;
    public Value(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Value : "+hashCode()+"i = " + i;
    }
}
public class FinalData {
    static final Value VALUE_1 = new Value(1);
    final Value value2 = new Value(2);

    public static void main(String[] args) {
        FinalData fd1 = new FinalData();
        System.out.println(fd1.VALUE_1);
        System.out.println(fd1.value2);
        System.out.println("Creating new FinalData");
        FinalData fd2 = new FinalData();
        System.out.println(fd2.VALUE_1);
        System.out.println(fd2.value2);
    }
}
