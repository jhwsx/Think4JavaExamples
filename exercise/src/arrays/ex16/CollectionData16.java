package arrays.ex16;

import java.util.ArrayList;

public class CollectionData16<T> extends ArrayList<T> {
  public CollectionData16(SkipGenerator<T> gen, int quantity) {
    for(int i = 0; i < quantity; i++)
      add(gen.next());
  }
  public CollectionData16(SkipGenerator<T> gen, int skip, int quantity) {
    for(int i = 0; i < quantity; i++)
      add(gen.next(skip));
  }
  // A generic convenience method:
  public static <T> CollectionData16<T>
  list(SkipGenerator<T> gen, int quantity) {
    return new CollectionData16<T>(gen, quantity);
  }
  public static <T> CollectionData16<T>
  list(SkipGenerator<T> gen, int skip, int quantity) {
    return new CollectionData16<T>(gen, skip, quantity);
  }
} ///:~