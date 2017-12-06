/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */

package com.company;

import com.company.Types.Operators;

import java.lang.reflect.Array;

public class MyMatrix<T extends Number & Operators<T>> {

    T[][] matrix;
    T[] vector;
    T temp;
    private final Class<?> cls = Number.class;
    private int size;

    public int getSize() {
        return size;
    }

    public MyMatrix(int size) {
        this.size = size;
        vector = (T[]) Array.newInstance(cls, size);
    }

    public MyMatrix(int row, int col) {
        this.size = size;
        matrix = (T[][]) Array.newInstance(cls, row, col);
    }

    public T getMatrixElement(int x, int y) {
        return matrix[x][y];
    }

    public void setMatrixElement(int x, int y, T element) {
        matrix[x][y] = element;
    }

    public T getVectorElement(int x) {
        return vector[x];
    }

    public void setVectorElement(int x, T element) {
        vector[x] = element;
    }

    public T addElement(T a, T x) {
        return a.add(x);
    }

    public T subtractElement(T a, T x) {
        return a.subtract(x);
    }

    public T multiplyElement(T a, T x) {
        return a.multiply(x);
    }

    public T divideElement(T a, T x) {
        return a.divide(x);
    }

    public T getTemp() {
        return temp;
    }

    public void setTemp(T temp) {
        this.temp = temp;
    }

    public T zeroElement(T A) {
        return A.zero();
    }

    public boolean lessElement(T A, T X) {
        return A.lessThan(X);
    }

}
