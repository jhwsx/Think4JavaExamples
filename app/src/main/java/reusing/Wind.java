package reusing;

/**
 * 向上转型
 * @author wzc
 * @date 2019/7/12
 */
class Instrument {
    public void play() {

    }

    static void tune(Instrument instrument) {
        instrument.play();
    }
}

public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        flute.tune(flute);
    }
}
