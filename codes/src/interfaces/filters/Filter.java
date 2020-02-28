package interfaces.filters;

/**
 * @author wzc
 * @date 2019/7/17
 */
public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
