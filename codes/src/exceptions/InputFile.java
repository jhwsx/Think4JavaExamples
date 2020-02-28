package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 在构造器中处理异常
 */
public class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            // 文件没有打开，所以不用关闭它
            throw e;
        } catch (Exception e) {
            // 其他的异常，必须关闭它
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("in.close() fail");
            }
            throw e; // 再次抛出
        } finally {
            // 不要在这里关闭！！！
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }

    public static void main(String[] args) {
        try {
            InputFile inputFile = new InputFile("G:\\AndroidWorkspaces\\Think4JavaExamples\\app\\src\\main\\java\\holding\\SetOperations.java");
            System.out.println(inputFile.getLine());
            System.out.println(inputFile.getLine());
            System.out.println(inputFile.getLine());
            System.out.println(inputFile.getLine());
            inputFile.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
