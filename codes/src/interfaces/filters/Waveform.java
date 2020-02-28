package interfaces.filters;

/**
 * @author wzc
 * @date 2019/7/17
 */
public class Waveform {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}
