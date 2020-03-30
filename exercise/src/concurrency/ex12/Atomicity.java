package concurrency.ex12;

/**
 * 证明在 Java 中 ++ 和 += 不是原子操作。
 * 使用 javap -c Atomicity 查看：
 * 每条指令都会产生一个 get 和 put，它们之间还有一些其他指令。
 * 因此，在获取和放置之间，另一个任务可能修改这个域，所以，这些
 * 操作不是原子性的。
 *
 * @author wangzhichao
 * @since 2020/3/9
 */
public class Atomicity {
    volatile int i;

     void f1() {
        i++;
    }

     synchronized void f2() {
        i += 3;
    }

      int get() {
        return i;
    }
}

/*
Compiled from "Atomicity.java"
public class concurrency.Atomicity {
  int i;

  public concurrency.Atomicity();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  void f1();
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field i:I
       5: iconst_1
       6: iadd
       7: putfield      #2                  // Field i:I
      10: return

  void f2();
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field i:I
       5: iconst_3
       6: iadd
       7: putfield      #2                  // Field i:I
      10: return
}

 */
