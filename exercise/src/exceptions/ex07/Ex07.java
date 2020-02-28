package exceptions.ex07;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex07 {
    private static Logger logger =
            Logger.getLogger("Ex07");
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        try {
            arr[4] = 5;
        } catch (Exception e) {
            e.printStackTrace();
            logException(e);
        }
    }
}
