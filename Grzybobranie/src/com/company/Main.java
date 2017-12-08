package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int wallsInDice = 7;


        Dice classicDice = new Dice(wallsInDice);
        Dice falseDice = new Dice(wallsInDice, randPossibilities(wallsInDice));

//        for (int i = 0 ; i < falseDice.getElementOfDice().size() ; i++) {
//            System.out.println(falseDice.getElementOfDice().get(i).getNumber());
//        }
        int q = 0,w = 0,e = 0,r = 0,t = 0,y = 0,u = 0;

        for (int i = 0 ; i <1000; i++ ){
            if (falseDice.throwDice() == -3) q++;
            if (falseDice.throwDice() == -2) w++;
            if (falseDice.throwDice() == -1) e++;
            if (falseDice.throwDice() == 0) r++;
            if (falseDice.throwDice() == 1) t++;
            if (falseDice.throwDice() == 2) y++;
            if (falseDice.throwDice() == 3) u++;
        }
        System.out.println(q-q + " " + (w-q) + " " + (e-q) + " " + (r-q) + " " + (t-q) + " " + (y-q) + " " + (u-q) );

    }





    private static List<Double> randPossibilities(int size) {
//        ArrayList<Double> test = new ArrayList<>();
//        Random rand = new Random();
//
//        for (int i = 0; i < 10; i++) {
//            test.add(Double.valueOf(rand.nextInt(100)) / 10);
//        }
////        SPRAWDZA CZY LICZBA MA ROZWINIECIE PO PRZECINKU, JAK TAK TO MNOZY RAZY 10
////        ABY POZBYC SIE GO.
////        ROBIMY ZEBY DODAC ILES ELEMENTOW DO TABLICY ( PRAWDOPODOBIENSTWO WYSTAPIEN )
////        IM WIEKSZE PRAWDOPODOBIENSTWO TYM WIECEJ LICZB
////        !!! PROBLEMEM MOZE BYC OVELOAD INTEGEREA !!!
//        for (int i = 0; i < 10; i++) {
//            if (test.get(i) % 1 != 0) {
//                for (int j = 0; j < 10; j++) {
//                    test.set(j, test.get(j) * 10);
//                }
//            }
//        }
////        DODAJE TYLE ILE POWYZSZA FUNKCJA WYLICZYLA PRAWDOPODOBIENSTWO
////        JEZELI PRAWDOPODOBIENSTWO WYNIOSLO 3/10 TO WYLICZY PRAWDOPODOBIENSTWO 0.3 -> 3
////        DODA WIEC 3 RAZY DANA LICZBE
//        ArrayList<Integer> lista = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < test.get(i); j++) {
//                lista.add(i);
//            }
//        }

        List<Double> result = new ArrayList<>();
        result.add(0.05);
        result.add(0.2);
        result.add(0.4);
        result.add(0.1);
        result.add(0.05);
        result.add(0.03);
        result.add(0.17);

        for (int i = 0; i < size; i++) {
            while (result.get(i) % 1 != 0) {
                for (int j = 0; j < size; j++) {
                    result.set(j, result.get(j) * 10);

                }
            }
        }

        return result;
    }
}
