package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Settings {

    int n;
    int k;
    List<Integer> mushrooms = new ArrayList<Integer>();
    int p1Start;
    int p2Start;
    int l;
    List<Integer> wallsValues = new ArrayList<Integer>();
    List<Double> wallsProbability = new ArrayList<Double>();


    public Settings(String filename) throws FileNotFoundException {

        File data = new File(filename);
        Scanner scanner = new Scanner(data);

        String line = scanner.nextLine();
        Scanner lineScanner = new Scanner(line);
        this.n = lineScanner.nextInt();
        lineScanner.close();

        line = scanner.nextLine();
        lineScanner = new Scanner(line);
        k = lineScanner.nextInt();
        while (lineScanner.hasNextInt())
        {
            mushrooms.add(lineScanner.nextInt());
        }
        lineScanner.close();

        line = scanner.nextLine();
        lineScanner = new Scanner(line);

        p1Start = lineScanner.nextInt();
        p2Start = lineScanner.nextInt();
        lineScanner.close();

        line = scanner.nextLine();
        lineScanner = new Scanner(line);
        l = lineScanner.nextInt();
        lineScanner.close();

        line = scanner.nextLine();
        lineScanner = new Scanner(line);
        while (lineScanner.hasNextInt())
        {
            wallsValues.add(lineScanner.nextInt());
        }

        lineScanner.close();

        line = scanner.nextLine();
        lineScanner = new Scanner(line);
        while (lineScanner.hasNextDouble())
        {
            wallsProbability.add(lineScanner.nextDouble());
        }


        lineScanner.close();
        scanner.close();
    }

    public int getN() {
        return n;
    }

    public int getK() {
        return k;
    }

    public List<Integer> getMushrooms() {
        return mushrooms;
    }

    public int getP1Start() {
        return p1Start;
    }

    public int getP2Start() {
        return p2Start;
    }

    public int getL() {
        return l;
    }

    public List<Integer> getWallsValues() {
        return wallsValues;
    }

    public List<Double> getWallsProbability() {
        return wallsProbability;
    }

    public List<DiceElement> createDiceElements() {
        List<DiceElement> diceElements = new ArrayList<>();

        for (int i = 0; i < wallsValues.size(); i++) {
            diceElements.add(new DiceElement(wallsValues.get(i), wallsProbability.get(i)));
        }

        return diceElements;
    }
}
