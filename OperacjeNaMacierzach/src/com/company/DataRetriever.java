/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */

package com.company;

import com.company.Types.MyDouble;
import com.company.Types.MyType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class DataRetriever {
    public static void saveToFileMatrix(int size) throws FileNotFoundException {

        PrintWriter zapis1 = new PrintWriter("MatrixA.txt");
        PrintWriter zapis2 = new PrintWriter("MatrixB.txt");
        PrintWriter zapis3 = new PrintWriter("MatrixC.txt");
        PrintWriter zapis4 = new PrintWriter("Vector.txt");


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                zapis1.print(randNumber() + " ");
                zapis2.print(randNumber() + " ");
                zapis3.print(randNumber() + " ");
            }
            zapis1.println();
            zapis2.println();
            zapis3.println();
            zapis4.println(randNumber());
        }
        zapis1.close();
        zapis2.close();
        zapis3.close();
        zapis4.close();
    }

    private static double randNumber() {
        Random r = new Random();
        double temp = r.nextInt(100);
        temp = temp / 10;
        return temp;
    }

    public static MyMatrix<MyDouble> readFromFileSaveToMatrix(String path, int size) {
        Scanner scan;
        File file = new File(path);
        MyMatrix matrix = new MyMatrix(size, size);

        double d;
        int i = 0, j = 0;

        try {
            scan = new Scanner(file);
            while (scan.hasNext()) {
                if (j < size) {
                    d = Double.parseDouble(scan.next());
                    MyDouble element = new MyDouble(d);

                    matrix.setMatrixElement(i, j, element);

                    j++;
                } else {
                    j = 0;
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    public static MyMatrix<MyDouble> readFromFileSaveToVector(String path, int size) {
        Scanner scan;
        File file = new File(path);
        MyMatrix vector = new MyMatrix(size);

        double d;
        int i = 0;

        try {
            scan = new Scanner(file);
            while (scan.hasNext()) {
                if (i < size) {
                    d = Double.parseDouble(scan.next());
                    MyDouble element = new MyDouble(d);

                    vector.setVectorElement(i, element);

                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return vector;
    }

    public static void printTimeToFile(int size, double elapsedTime, String path) throws FileNotFoundException {
        PrintWriter zapis;
        String file ="times/" + path + ".txt";
        try {
            zapis = new PrintWriter(file);

            zapis.format("%10.2f%n", elapsedTime);

            zapis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMatrixToFile(int size, MyMatrix matrix, String path) throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        double temp = 0.0;
        PrintWriter zapis;
        String file ="result/" + path + ".txt";
        try {
            zapis = new PrintWriter(file);

            for (int col = 0; col < size; col++) {
//                temp += matrix.getVectorElement(col).doubleValue();
                zapis.format("%10.16f%n", matrix.getVectorElement(col).doubleValue());
            }

            zapis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMatrixMyTypeToFile(int size, MyMatrix matrix, String path) throws FileNotFoundException {
        double temp = 0.0;
        PrintWriter zapis;
        String file ="result/" + path + ".txt";
        try {
            zapis = new PrintWriter(file);

            for (int col = 0; col < size; col++) {
                zapis.println(matrix.getVectorElement(col));
            }


            zapis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
