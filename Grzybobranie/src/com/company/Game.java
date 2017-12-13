package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Game {

    private Dice dice;
    private Flashcard flashcard;
//    private Mashrooms Mashrooms; ???
    private DiceElement rolledDiceElement = null;

    private Map<Integer, List<Case>> casesList;

    public Game(Dice dice, Flashcard flashcard) {
        this.dice = dice;
        this.flashcard = flashcard;
        this.casesList = new TreeMap<>();

        for (int i = 0; i < flashcard.getNumberOfFields(); i++) {
            int field = countfield(i);

            System.out.println(" asdasdasdas" + field);
            casesList.put(field, new ArrayList<Case>());
        }


    }

    public void Play() {

//        Equation equation = new Equation();

        System.out.println("***ZACZYNAMY GRE***");
        System.out.println("Pozycja gracza 1: " + flashcard.getP1Start());
        System.out.println("Pozycja gracza 2: " + flashcard.getP2Start());
        System.out.println();
        while(flashcard.getP1Start() != 0 && flashcard.getP2Start() !=0) {

            System.out.println();
            System.out.println("Losuje gracz 1 !!!");

            rolledDiceElement = dice.throwDice();

            System.out.println("Wylosowano: " + rolledDiceElement.getNumber() + " z prawdopodobienstwem: " + rolledDiceElement.getProbabiliy());
            flashcard.setP1Start((flashcard.getP1Start() + rolledDiceElement.getNumber())%flashcard.getNumberOfFields());

            System.out.println("Pozycja gracza 1: " + flashcard.getP1Start());
        }

    }

    public int countfield(int i)
    {
        if(i == flashcard.getNumberOfFields() -1)
            return 0;

        int n = (flashcard.getNumberOfFields() - 1) /2;
        int field;
        if(i < n )
            field = - i -1;
        else
            field = n - (i%n)  ;

        return field;
    }

}
