/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */

package com.company.Types;

public class MyFloat extends Number implements Operators<MyFloat> {

    public Float value;

    public MyFloat(Float value) {
        this.value = value;
    }


    @Override
    public MyFloat add(MyFloat x) {
        return new MyFloat(value + x.value);
    }

    @Override
    public MyFloat subtract(MyFloat x) {
        return new MyFloat(value - x.value);
    }

    @Override
    public MyFloat multiply(MyFloat x) {
        return new MyFloat(value * x.value);
    }

    @Override
    public MyFloat divide(MyFloat x) {
        return new MyFloat(value / x.value);
    }

    @Override
    public MyFloat zero() {
        return new MyFloat(Float.valueOf(0));
    }

    @Override
    public boolean lessThan(MyFloat x) {
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
