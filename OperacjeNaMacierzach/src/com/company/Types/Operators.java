/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */

package com.company.Types;

public interface Operators<T> {

    T add(T x);

    T subtract(T x);

    T multiply(T x);

    T divide(T x);

    T zero();

    boolean lessThan(T x);
}
