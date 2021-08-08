//: net/net.net.mindview/util/OSExecute.java
// Run an operating system command
// and send the output to the console.
package io.ex22;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExecute {
    public static String command(String command) {
        boolean err = false;
        StringBuilder sb = new StringBuilder();
        try {
            // ProcessBuilder 用于创建操作系统进程
            Process process =
                    new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null)
                sb.append(s).append("\n");
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            // Report errors and return nonzero value
            // to calling process if there are problems:
            while ((s = errors.readLine()) != null) {
                sb.append(s).append("\n");
                err = true;
            }
        } catch (Exception e) {
            // Compensate for Windows 2000, which throws an
            // exception for the default command line:
            if (!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if (err)
            throw new OSExecuteException("Errors executing " +
                    command);
        return sb.toString();
    }
} ///:~
