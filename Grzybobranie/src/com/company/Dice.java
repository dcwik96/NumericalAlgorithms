package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {

    private List<DiceElement> elementsOfDice;

    public Dice(List<DiceElement> elementOfDice) {
        this.elementsOfDice = elementOfDice;
    }

    //FUNCTIONS


    public DiceElement throwDice() {
        return elementsOfDice.get(new Random().nextInt(elementsOfDice.size()));
    }

    public List<DiceElement> getElementOfDice() {
        return elementsOfDice;
    }
}
