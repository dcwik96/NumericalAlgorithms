package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {

    private int numberOfWalls;
    private List<DiceElement> elementOfDice;

    public Dice(int numberOfWalls) {
        this.numberOfWalls = numberOfWalls;
        this.elementOfDice = addClassicNumbers();
    }

    public Dice(int numberOfWalls, List<Double> possibilites) {
        this.numberOfWalls = numberOfWalls;
        this.elementOfDice = addFalseNumbers(possibilites);
    }


    //GETTERS AND SETTERS
    public int getNumberOfWalls() {
        return numberOfWalls;
    }

    public void setNumberOfWalls(int numberOfWalls) {
        this.numberOfWalls = numberOfWalls;
    }

    public List<DiceElement> getElementOfDice() {
        return elementOfDice;
    }

    public void setElementOfDice(List<DiceElement> elementOfDice) {
        this.elementOfDice = elementOfDice;
    }


    //FUNCTIONS
    public List<DiceElement> addClassicNumbers() {
        List<DiceElement> numbersOfDice = new ArrayList<>();
        DiceElement diceElement;

        for (int i = -(numberOfWalls / 2); i <= numberOfWalls / 2; i++) {
            diceElement = new DiceElement(i);
            numbersOfDice.add(diceElement);
        }
        return numbersOfDice;
    }

    public List<DiceElement> addFalseNumbers(List<Double> possibilities) {
        List<DiceElement> numbersOfDice = new ArrayList<>();
        DiceElement diceElement;

        for (int i = -(numberOfWalls / 2), j=0; i <= numberOfWalls / 2; i++, j++) {
            int end = possibilities.get(j).intValue();
            for (int a = 0; a < end; a++) {
                diceElement = new DiceElement(i);
                numbersOfDice.add(diceElement);
            }
        }
        System.out.println(numbersOfDice.size());

        return numbersOfDice;
    }

    public int throwDice() {
        return elementOfDice.get(new Random().nextInt(elementOfDice.size())).getNumber();
    }

}
