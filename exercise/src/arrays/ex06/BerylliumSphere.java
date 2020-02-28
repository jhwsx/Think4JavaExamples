package arrays.ex06;

public class BerylliumSphere {
    private static long counter;
    public final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id + ",hashCode=" + hashCode();
    }
}