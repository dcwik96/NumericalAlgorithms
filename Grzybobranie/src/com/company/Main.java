package com.company;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Settings settings;
        settings = new Settings("settings.txt");

        Dice dice = new Dice(settings.createDiceElements());
        Flashcard flashcard = new Flashcard(settings.getP1Start(), settings.getP2Start(), settings.getN());
//        STWORZYC MASZRUMY

        Game game = new Game(dice, flashcard);
        game.Play();


    }


    private static List<Double> randPossibilities(int number_of_parts) {
        Random r = new Random();
        int number = 100;

        HashSet<Integer> uniqueInts = new HashSet<>();
        uniqueInts.add(0);
        uniqueInts.add(number);
        int array_size = number_of_parts + 1;
        while (uniqueInts.size() < array_size) {
            uniqueInts.add(1 + r.nextInt(number - 1));
        }
        Integer[] dividers = uniqueInts.toArray(new Integer[array_size]);
        Arrays.sort(dividers);
        List<Double> results = new ArrayList<>();
        for (int i = 1, j = 0; i < dividers.length; ++i, ++j) {
            results.add((double) (dividers[i] - dividers[j]));
            System.out.println(results.get(j));
        }
        return results;
    }
}
