package com.company;

import java.util.ArrayList;
import java.util.List;

public class Case {

    private int firstPlayerPosition;
    private int secondPlayerPosition;

    private List<Equation> equations;

    public Case(int firstPlayerPosition, int secondPlayerPosition) {
        this.firstPlayerPosition = firstPlayerPosition;
        this.secondPlayerPosition = secondPlayerPosition;
        this.equations = new ArrayList<>();
    }

    public int getFirstPlayerPosition() {
        return firstPlayerPosition;
    }

    public void setFirstPlayerPosition(int firstPlayerPosition) {
        this.firstPlayerPosition = firstPlayerPosition;
    }

    public int getSecondPlayerPosition() {
        return secondPlayerPosition;
    }

    public void setSecondPlayerPosition(int secondPlayerPosition) {
        this.secondPlayerPosition = secondPlayerPosition;
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public void setEquations(List<Equation> equations) {
        this.equations = equations;
    }

    @Override
    public String toString() {
        return new String("P1: "+firstPlayerPosition+" P2: "+secondPlayerPosition );
    }
}
