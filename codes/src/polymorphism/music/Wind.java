package polymorphism.music;

/**
 * @author wzc
 * @date 2019/7/13
 */
public class Wind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }
}
