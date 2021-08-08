package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2021/3/25
 */
public class CodeCopy {
    public static void main(String[] args) throws Exception {
        String filePath = "D:\\Android\\Workspace\\steptreasure\\app\\src\\main\\java";
        File dest = new File("buqianjin.txt");
        List<String> fileList = getAllFileName(filePath, "(Withdraw.*|NewHandStrategyActivity.*|Splash.*|Main.*|Mine.*|Settings.*|Logoff.*)");
        for (String s : fileList) {
            System.out.println(s);
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(dest));
        for (String s : fileList) {
            BufferedReader br = new BufferedReader(new FileReader(s));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("author") || line.contains("since") || line.contains("Chang.Xiao") || line.contains("*")) {
                    continue;
                }
                bw.write(line, 0, line.length());
                bw.newLine();
                bw.flush();
            }
            br.close();
        }
        bw.close();
        System.out.println("Success");
    }

    public static List<String> getAllFileName(String path, String regex) {
        File file = new File(path);
        List<String> result = new ArrayList<>();
        File[] tempList = file.listFiles();
        for (File value : tempList) {
            if (value.isFile() && value.getName().matches(regex)) {
                result.add(value.getAbsolutePath());
            }
            if (value.isDirectory()) {
                result.addAll(getAllFileName(value.getAbsolutePath(), regex));
            }
        }
        return result;
    }
}


