package polymorphism.music;

/**
 * @author wzc
 * @date 2019/7/13
 */
public class Music {
    public static void tune(Instrument instrument) {
        System.out.println(instrument);
        instrument.play(Note.MIDDLE_C);
    }
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}
