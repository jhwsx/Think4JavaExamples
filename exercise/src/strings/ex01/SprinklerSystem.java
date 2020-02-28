package strings.ex01;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class SprinklerSystem {
    private String valve1, valve2,valve3,valve4;
    private WaterSource source = new WaterSource();
    private int mInt;
    private float mFloat;

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "valve1='" + valve1 + '\'' +
                ", valve2='" + valve2 + '\'' +
                ", valve3='" + valve3 + '\'' +
                ", valve4='" + valve4 + '\'' +
                ", source=" + source +
                ", mInt=" + mInt +
                ", mFloat=" + mFloat +
                '}';
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }
}

class WaterSource {
    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

/*

G:\AndroidWorkspaces\Think4JavaExamples\exercise\src\main\java>javac strings/ex01/SprinkleSystem.java
javac: 找不到文件: strings\ex01\SprinkleSystem.java
用法: javac <options> <source files>
-help 用于列出可能的选项

G:\AndroidWorkspaces\Think4JavaExamples\exercise\src\main\java>jacac strings/ex01/SprinklerSystem.java
'jacac' 不是内部或外部命令，也不是可运行的程序
或批处理文件。

G:\AndroidWorkspaces\Think4JavaExamples\exercise\src\main\java>javac strings/ex01/SprinklerSystem.java

G:\AndroidWorkspaces\Think4JavaExamples\exercise\src\main\java>javap -c strings/ex01/SprinklerSystem
Compiled from "SprinklerSystem.java"
public class strings.ex01.SprinklerSystem {
  public strings.ex01.SprinklerSystem();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: new           #2                  // class strings/ex01/WaterSource
       8: dup
       9: invokespecial #3                  // Method strings/ex01/WaterSource."<init>":()V
      12: putfield      #4                  // Field source:Lstrings/ex01/WaterSource;
      15: return

  public java.lang.String toString();
    Code:
       0: new           #5                  // class java/lang/StringBuilder
       3: dup
       4: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
       7: ldc           #7                  // String SprinklerSystem{valve1='
       9: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      12: aload_0
      13: getfield      #9                  // Field valve1:Ljava/lang/String;
      16: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: bipush        39
      21: invokevirtual #10                 // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
      24: ldc           #11                 // String , valve2='
      26: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      29: aload_0
      30: getfield      #12                 // Field valve2:Ljava/lang/String;
      33: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      36: bipush        39
      38: invokevirtual #10                 // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
      41: ldc           #13                 // String , valve3='
      43: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      46: aload_0
      47: getfield      #14                 // Field valve3:Ljava/lang/String;
      50: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      53: bipush        39
      55: invokevirtual #10                 // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
      58: ldc           #15                 // String , valve4='
      60: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      63: aload_0
      64: getfield      #16                 // Field valve4:Ljava/lang/String;
      67: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      70: bipush        39
      72: invokevirtual #10                 // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
      75: ldc           #17                 // String , source=
      77: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      80: aload_0
      81: getfield      #4                  // Field source:Lstrings/ex01/WaterSource;
      84: invokevirtual #18                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      87: ldc           #19                 // String , mInt=
      89: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      92: aload_0
      93: getfield      #20                 // Field mInt:I
      96: invokevirtual #21                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      99: ldc           #22                 // String , mFloat=
     101: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
     104: aload_0
     105: getfield      #23                 // Field mFloat:F
     108: invokevirtual #24                 // Method java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
     111: bipush        125
     113: invokevirtual #10                 // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
     116: invokevirtual #25                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
     119: areturn

  public static void main(java.lang.String[]);
    Code:
       0: new           #26                 // class strings/ex01/SprinklerSystem
       3: dup
       4: invokespecial #27                 // Method "<init>":()V
       7: astore_1
       8: getstatic     #28                 // Field java/lang/System.out:Ljava/io/PrintStream;
      11: aload_1
      12: invokevirtual #29                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      15: return
}

G:\AndroidWorkspaces\Think4JavaExamples\exercise\src\main\java>



*/
