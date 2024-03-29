package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wangzhichao
 * @since 2021/7/18
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }
}
