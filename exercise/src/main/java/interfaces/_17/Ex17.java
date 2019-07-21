package interfaces._17;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface Days {
    int SUNDAY = 1;
    int MONDAY = 2;
    int TUESDAY = 3;
    int WEDNESDAY = 4;
    int THURSDAY = 5;
    int FRIDAY = 6;
    int SATURDAY = 7;
}

class Week implements Days {
    public Week() {
        System.out.println("Week()");
    }
}
public class Ex17 {
    public static void main(String[] args) {
        System.out.println(Days.SUNDAY);
        Week week = new Week();
//        week.SUNDAY = 2;
    }
}
