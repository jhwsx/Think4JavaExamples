package interfaces.music5;

import polymorphism.music.Note;

/**
 * @author wzc
 * @date 2019/7/13
 */
interface Instrument {
    void play(Note n);
    void adjust();
}

class Wind implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    public String toString() {
        return "Brass";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Brass");
    }
}

class WoodWind extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("WoodWind.play() " + n);
    }

    @Override
    public String toString() {
        return "WoodWind";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting WoodWind");
    }
}

public class Music5 {
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] instruments) {
        for (Instrument instrument : instruments) {
            tune(instrument);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new WoodWind()
        };
        tuneAll(orchestra);
    }
}
