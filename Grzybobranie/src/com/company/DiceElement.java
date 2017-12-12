package com.company;

public class DiceElement {

    private int number;
    private double probabiliy;

    public DiceElement() {
    }

    public DiceElement(int number, double probability) {
        this.number = number;
        this.probabiliy = probability;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getProbabiliy() {
        return probabiliy;
    }

    public void setProbabiliy(double probabiliy) {
        this.probabiliy = probabiliy;
    }
}
