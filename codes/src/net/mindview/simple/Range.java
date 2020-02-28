package net.mindview.simple;

/**
 * @author wzc
 * @date 2019/6/14
 */
public class Range {
    // 产生[0,n)的序列
    public static int[] range(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }

    public static int[] range(int start, int end) {
        int sz = end - start;
        int[] result = new int[sz];
        for (int i = 0; i < sz; i++) {
            result[i] = start + i;
        }
        return result;
    }

    public static int[] range(int start, int end,int step) {
        int sz = end - start;
        int[] result = new int[sz];
        for (int i = 0; i < sz; i++) {
            result[i] = start + i * step;
        }
        return result;
    }

}
