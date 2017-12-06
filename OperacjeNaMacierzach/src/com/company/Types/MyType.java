/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */

package com.company.Types;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MyType extends Number implements Operators<MyType> {

    public BigInteger nominator;
    public BigInteger denominator;
    public BigInteger sign = new BigInteger("1");

    public MyType(BigInteger nominator, BigInteger denominator, BigInteger sign) {
        this.nominator = nominator;
        this.denominator = denominator;
        this.sign = sign;
        if (this.denominator.equals(BigInteger.valueOf(0)))
            throw new ArithmeticException("Lk equals 0 -fatal");

        if (this.nominator.compareTo(BigInteger.valueOf(0)) == -1)
            throw new ArithmeticException("Mn less than 0 in constructor");

        if (!this.nominator.equals(BigInteger.valueOf(0)))
            this.reductFraction();
    }

    public MyType(Double number) {
        if (number < 0) {

            sign = sign.multiply(BigInteger.valueOf(-1));
            number *= -1;
        }
        String num = String.valueOf(number);
        BigInteger hp_mn = BigInteger.valueOf(0);
        BigInteger hp_lk = BigInteger.valueOf(1);
        char arr[] = num.toCharArray();
        long after_dot = 0;
        for (char x : arr) {
            if (x != '.') {
                hp_mn = hp_mn.multiply(BigInteger.valueOf(10));
                hp_mn = hp_mn.add(BigInteger.valueOf(Character.getNumericValue(x)));

            }
            if (after_dot == 1) {
                hp_lk = hp_lk.multiply(BigInteger.valueOf(10));
            }
            if (x == '.') {
                after_dot++;
            }
        }
        this.nominator = hp_mn;
        this.denominator = hp_lk;
        if (this.denominator.equals(BigInteger.valueOf(0)))
            throw new ArithmeticException("Denominator equals 0 -fatal");
        if (this.nominator.compareTo(BigInteger.valueOf(0)) == -1)
            throw new ArithmeticException("Nominator less than 0 in consturctor");
        if (!this.nominator.equals(BigInteger.valueOf(0)))
            this.reductFraction();
    }

    public BigInteger getMn() {
        return nominator;
    }

    public void setMn(BigInteger nominator) {
        this.nominator = nominator;
    }

    public BigInteger getLk() {
        return denominator;
    }

    public void setLk(BigInteger denominator) {
        this.denominator = denominator;
    }

    public BigInteger getSign() {
        return sign;
    }

    public void setSign(BigInteger sign) {
        this.sign = sign;
    }


    private void reductFraction() {
        BigInteger gcd;
        do {
            gcd = nominator.gcd(denominator);
            nominator = nominator.divide(gcd);
            denominator = denominator.divide(gcd);
        } while (!gcd.equals(BigInteger.valueOf(1)));
    }

    private BigInteger NWW(BigInteger A, BigInteger B) {
        BigInteger NWW = A.multiply(B);
        NWW = NWW.divide(A.gcd(B));
        return NWW;
    }


    @Override
    public MyType add(MyType x) {
        BigInteger scp = NWW(this.denominator, x.getLk());
        BigInteger multiplierFirstFraction = scp.divide(this.denominator);
        BigInteger multiplierSecondFraction = scp.divide(x.getLk());

        BigInteger newMnFirst = this.sign.multiply(this.nominator).multiply(multiplierFirstFraction);
        BigInteger newMnSecond = x.getSign().multiply(x.getMn()).multiply(multiplierSecondFraction);
        newMnFirst = newMnFirst.add(newMnSecond);
        BigInteger newSign = new BigInteger("1");
        if (newMnFirst.signum() != 1) {
            newMnFirst = newMnFirst.multiply(BigInteger.valueOf(-1));
            newSign = newSign.multiply(BigInteger.valueOf(-1));
        }

        return new MyType(newMnFirst, this.denominator.multiply(multiplierFirstFraction), newSign);
    }


    @Override
    public MyType subtract(MyType x) {
        BigInteger scp = NWW(this.denominator, x.getLk());
        BigInteger multiplierFirstFraction = scp.divide(this.denominator);
        BigInteger multiplierSecondFraction = scp.divide(x.getLk());

        BigInteger newMnFirst = this.sign.multiply(this.nominator).multiply(multiplierFirstFraction);
        BigInteger newMnSecond = x.getSign().multiply(x.getMn()).multiply(multiplierSecondFraction);
        newMnFirst = newMnFirst.subtract(newMnSecond);
        BigInteger newSign = new BigInteger("1");
        if (newMnFirst.signum() != 1) {
            newMnFirst = newMnFirst.multiply(BigInteger.valueOf(-1));
            newSign = newSign.multiply(BigInteger.valueOf(-1));
        }

        return new MyType(newMnFirst, this.denominator.multiply(multiplierFirstFraction), newSign);
    }

    @Override
    public MyType multiply(MyType x) {
        BigInteger mn1 = this.nominator.multiply(x.getMn());
        BigInteger lk1 = this.denominator.multiply(x.getLk());
        BigInteger sign1 = this.sign.multiply(x.getSign());

        return new MyType(mn1, lk1, sign1);
    }

    @Override
    public MyType divide(MyType x) {
        BigInteger mn1 = this.nominator.multiply(x.getLk());
        BigInteger lk1 = this.denominator.multiply(x.getMn());
        BigInteger sign1 = this.sign.multiply(x.getSign());

        return new MyType(mn1, lk1, sign1);
    }

    @Override
    public MyType zero() {
        return new MyType(BigInteger.valueOf(0), BigInteger.valueOf(1), BigInteger.valueOf(1));
    }

    @Override
    public boolean lessThan(MyType x) {
        BigInteger scp = NWW(this.denominator, x.getLk());
        BigInteger multiplierFirstFraction = scp.divide(this.denominator);
        BigInteger multiplierSecondFraction = scp.divide(x.getLk());

        BigInteger newMnFirst = this.sign.multiply(this.nominator).multiply(multiplierFirstFraction);
        BigInteger newMnSecond = x.getSign().multiply(x.getMn()).multiply(multiplierSecondFraction);

        if (newMnFirst.compareTo(newMnSecond) == -1)
            return true;
        else
            return false;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return nominator.multiply(sign).divide(denominator).floatValue();
    }

    @Override
    public double doubleValue() {
        return nominator.multiply(sign).divide(denominator).doubleValue();
    }

    @Override
    public String toString() {
        return nominator.multiply(sign).toString() + "/" + denominator.toString();
    }

}
