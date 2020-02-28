package exceptions.ex24;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class NeedsCleanup {
    public void dispose() {
        System.out.println("NeedsCleanup " + " disposed");
    }
}

class FailingConstructor {
    private BufferedReader in;
     NeedsCleanup nc;
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
        nc = new NeedsCleanup();
    }

    public void dispose() {
        System.out.println("FailingConstructor dispose");
    }

}

public class Ex24 {
    public static void main(String[] args) {
        try {
            FailingConstructor fc = new FailingConstructor("G:\\AndroidWorkspaces\\Think4JavaExamples\\app\\src\\main\\java\\holding\\SetOperations.java");
            try {

            } finally {
                fc.nc.dispose();
                fc.dispose();
            }
        } catch (Exception e) {
            System.out.println("FailingConstructor construction failed");
        }
    }
}
