package io.ex17;

import net.mindview.util.TextFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 用 TextFile 和 Map<Character, Integer> 创建一个程序，它可以对在一个文件中
 * 所有不同的字符出现的次数进行计数。（因此如果在文件中字母 a 出现了 12 次，那么在
 * Map 中包含 a 的 Character 相关联的 Integer 就包含 12）。
 *
 * @author wangzhichao
 * @since 2021/7/18
 */
public class Ex17 {
    static String file = "D:\\Android\\Workspace\\github\\Think4JavaExamples\\exercise\\src\\io\\ex17\\Ex17.java";
    public static void main(String[] args) {
        String read = TextFile.read(file);
        // 字符串转为字符数组
        char[] chars = read.toCharArray();
//        System.out.println(Arrays.toString(chars));
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                count++;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println(map);
    }
}
