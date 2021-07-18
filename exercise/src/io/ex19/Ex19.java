package io.ex19;

import net.mindview.util.BinaryFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 用 BinaryFile 和 Map<Byte, Integer> 创建一个程序，它可以对在一个文件中所有不同的字节出现的次数进行计数。
 *
 * @author wangzhichao
 * @since 2021/7/18
 */
public class Ex19 {
    static final String file = "D:\\Android\\Workspace\\github\\Think4JavaExamples\\exercise\\src\\io\\ex19\\Ex19.java";
    public static void main(String[] args) throws IOException {
        byte[] bytes = BinaryFile.read(file);
        Map<Byte, Integer> map = new HashMap<>();

        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (map.containsKey(b)) {
                int count = map.get(b);
                count++;
                map.put(b, count);
            } else {
                map.put(b, 1);
            }
        }

        System.out.println(map);
    }
}
