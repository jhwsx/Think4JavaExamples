package io;

import net.mindview.util.OSExecute;

/**
 * todo 为什么老是报错？
 *
 * @author wangzhichao
 * @since 2021/7/18
 */
public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("javap OSExecuteDemo");
    }
}
