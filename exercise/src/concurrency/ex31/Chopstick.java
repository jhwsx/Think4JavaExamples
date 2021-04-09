package concurrency.ex31;

/**
 * 一根筷子
 *
 * @author wangzhichao
 * @since 2021/4/9
 */
public class Chopstick {

    private int i;

    public Chopstick(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Chopstick " + i;
    }
}
