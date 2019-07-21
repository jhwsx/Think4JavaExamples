package initialization;

/**
 * @author wzc
 * @date 2019/5/31
 */
public class TerminationCondition {

    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
    }
}
