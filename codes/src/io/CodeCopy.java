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
        String filePath = "D:\\Workspace\\steptreasure\\app\\src\\main\\java";
        File dest = new File("buqianjin.txt");
        List<String> fileList = new ArrayList<>();
        getAllFileName(filePath, fileList);
        for (String s : fileList) {
            System.out.println(s);
        }
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (String s : fileList) {
            if (
                    s.contains("Feedback")
                            || s.contains("NewHandStrategyActivity")
//                            || s.contains("Splash")
//                            || s.contains("Main")
//                            || s.contains("Mine")
//                            || s.contains("Withdraw")
//                            || s.contains("Settings")
//                            || s.contains("Logoff")
            ) {
                FileInputStream fis = new FileInputStream(s);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains("author") || line.contains("since") || line.contains("Chang.Xiao") || line.contains("*")) {
                        continue;
                    }
                    bw.write(line, 0, line.length());
                    bw.write("\n");
                    bw.flush();
                }
                fis.close();
                br.close();
            }
        }
        System.out.println("Success");
    }

    public static void getAllFileName(String path, List<String> fileNameList) {
        File file = new File(path);
        File[] tempList = file.listFiles();
        for (File value : tempList) {
            if (value.isFile() && value.getAbsolutePath().endsWith(".java") || value.getAbsolutePath().endsWith(".kt")) {
                fileNameList.add(value.getAbsolutePath());
            }
            if (value.isDirectory()) {
                getAllFileName(value.getAbsolutePath(), fileNameList);
            }
        }
    }
}


