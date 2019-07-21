package initialization._21;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class EnumTest {
    public static void main(String[] args) {
        for (BankNote bankNote : BankNote.values()) {
            System.out.println(bankNote +", ordinal " + bankNote.ordinal());
        }
    }
}
