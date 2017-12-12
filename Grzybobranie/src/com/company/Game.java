package com.company;

import java.util.ArrayList;

public class Game {

    private Dice dice;
    private Flashcard flashcard;
//    private Mashrooms Mashrooms; ???

    private DiceElement rolledDiceElement = null;


    public Game(Dice dice, Flashcard flashcard) {
        this.dice = dice;
        this.flashcard = flashcard;
    }

    public void Play() {
        System.out.println("***ZACZYNAMY GRE***");
        System.out.println("Pozycja gracza 1: " + flashcard.getP1Start());
//        System.out.println("Pozycja gracza 2: " + flashcard.getP2Start());
        System.out.println();
        while(flashcard.getP1Start() != 0) {
            System.out.println();
            System.out.println("Losuje gracz 1 !!!");

            rolledDiceElement = dice.throwDice();

            System.out.println(dice.getElementOfDice().get(0).getProbabiliy() + " " + dice.getElementOfDice().get(0).getNumber());
            System.out.println(dice.getElementOfDice().get(1).getProbabiliy() + " " + dice.getElementOfDice().get(1).getNumber());
            System.out.println("Wylosowano: " + rolledDiceElement.getNumber() + " z prawdopodobienstwem: " + rolledDiceElement.getProbabiliy());
            flashcard.setP1Start((flashcard.getP1Start() + rolledDiceElement.getNumber())%flashcard.getNumberOfFields());
            System.out.println("Pozycja gracza 1: " + flashcard.getP1Start());
        }

    }

}
