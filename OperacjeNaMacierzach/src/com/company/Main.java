/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */

package com.company;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int size = 110;

        DataRetriever.saveToFileMatrix(size);
        Calculations calculations = new Calculations(size);

        calculations.prepareMatrix();
        calculations.count();

    }


}
