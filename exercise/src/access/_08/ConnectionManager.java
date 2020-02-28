package access._08;

import java.util.Arrays;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class ConnectionManager {
    private static Connection[] arr = new Connection[3];
    public static void main(String[] args) {
        ConnectionManager.makeConnection();
        System.out.println(Arrays.toString(arr));
        ConnectionManager.arr = null;
        System.out.println(Arrays.toString(arr));
    }

    public static void makeConnection() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Connection.newInstance();
        }
    }
}

class Connection {
    private Connection() {

    }

    public static Connection newInstance() {
        return new Connection();
    }
}
