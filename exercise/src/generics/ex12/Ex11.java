package generics.ex12;

import net.mindview.util.New;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author wangzhichao
 * @since 2019/12/15
 */
class A {}

class B {}


public class Ex11 {
    public static void main(String[] args) {
        Map<A, B> map = New.<A,B>map();
        List<A> list = New.<A>list();
        LinkedList<B> linkedList = New.<B>lList();
        Set<A> set = New.<A>set();
        Queue<B> queue = New.<B>queue();
    }
}
