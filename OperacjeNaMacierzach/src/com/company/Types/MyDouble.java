/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */

package com.company.Types;

public class MyDouble extends Number implements Operators<MyDouble>{
    public Double value;

    public MyDouble(Double value) {
        this.value = value;
    }

    @Override
    public MyDouble add(MyDouble x) {
        return new MyDouble(value + x.value);
    }

    @Override
    public MyDouble subtract(MyDouble x) {
        return new MyDouble(value - x.value);
    }

    @Override
    public MyDouble multiply(MyDouble x) {
        return new MyDouble(value * x.value);
    }

    @Override
    public MyDouble divide(MyDouble x) {
        return new MyDouble(value / x.value);
    }

    @Override
    public MyDouble zero() {
        return new MyDouble(Double.valueOf(0));
    }

    @Override
    public boolean lessThan(MyDouble x) {
        if(this.value < x.value)
            return true;
        else
            return false;
    }

    @Override
    public int intValue() {
        return value.intValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
