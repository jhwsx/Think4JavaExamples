package initialization._22;

import initialization._21.BankNote;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class EnumSwitchTest {
    public static void main(String[] args) {
        describe(BankNote.ONE);
        describe(BankNote.FIVE);
        describe(BankNote.TEN);
        describe(BankNote.TWENTY);
        describe(BankNote.FIFTY);
        describe(BankNote.HUNDRED);
    }

    static void describe(BankNote note) {
        switch (note) {
            case ONE:
                System.out.println("one");
                break;
            case FIVE:
                System.out.println("five");
                break;
            case TEN:
                System.out.println("ten");
                break;
            case TWENTY:
                System.out.println("twenty");
                break;
            case FIFTY:
                System.out.println("fifty");
                break;
            case HUNDRED:
                System.out.println("hundred");
                break;
            default:
        }
    }
}
