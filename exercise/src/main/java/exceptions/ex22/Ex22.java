package exceptions.ex22;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FailingConstructor {
    private BufferedReader in;
    public FailingConstructor(String fileName) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw e;
        } catch (Exception e) {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            throw e;
        }
    }
}
public class Ex22 {

}
