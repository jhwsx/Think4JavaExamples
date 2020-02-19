package arrays.ex21;

import java.util.Arrays;
import java.util.Comparator;

import arrays.ex06.BerylliumSphere;

/**
 * @author wzc
 * @date 2020/2/19
 */
class ComBerylliumSphere implements Comparable<ComBerylliumSphere> {
    private static long counter;
    public final long id = counter++;
    @Override
    public int compareTo(ComBerylliumSphere c2) {
        return (id < c2.id ? -1 : id == c2.id ? 0 : 1);
    }

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}

class ComBerylliumShereComparator implements Comparator<ComBerylliumSphere> {

    @Override
    public int compare(ComBerylliumSphere o1, ComBerylliumSphere o2) {
        return (o1.id > o2.id ? -1 : o1.id == o2.id ? 0 : 1);
    }
}
public class Ex21 {
    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres = {
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere()
        };
        // 这行报错：因为 java.lang.ClassCastException: arrays.ex06.BerylliumSphere cannot be cast to java.lang.Comparable
        // Arrays.sort(berylliumSpheres);
        ComBerylliumSphere[] comBerylliumSpheres = {
                new ComBerylliumSphere(),
                new ComBerylliumSphere(),
                new ComBerylliumSphere(),
                new ComBerylliumSphere(),
                new ComBerylliumSphere(),
        };
        System.out.println("before sorting");
        System.out.println(Arrays.toString(comBerylliumSpheres));
        System.out.println("after sorting");
        Arrays.sort(comBerylliumSpheres);
        System.out.println(Arrays.toString(comBerylliumSpheres));
        Arrays.sort(comBerylliumSpheres, new ComBerylliumShereComparator());
        System.out.println(Arrays.toString(comBerylliumSpheres));
    }
}
