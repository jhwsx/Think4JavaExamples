package interfaces._16;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class AdaptedRandomChars extends RandomChars implements Readable {
    private int count;

    public AdaptedRandomChars(int count) {
        this.count = count;
    }
    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }
        String result = Character.toString(next()) + " ";
        cb.append(result);
        return cb.length();
    }

    public static void main(String[] args) {
        AdaptedRandomChars adaptedRandomChars = new AdaptedRandomChars(100);
        Scanner scanner = new Scanner(adaptedRandomChars);
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + " ");
        }
    }
}
