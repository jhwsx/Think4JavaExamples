//: net/net.net.mindview/util/Generator.java
// A generic interface.
package net.mindview.util;

// Generator 泛型接口，具有一个 next() 方法返回一个具有其参数类型的对象。
public interface Generator<T> {
    T next();
} ///:~
