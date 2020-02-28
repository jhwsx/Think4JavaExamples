package arrays.ex16;

import net.mindview.util.Generator;

interface SkipGenerator<T> extends Generator<T> {
    T next(int n);
}