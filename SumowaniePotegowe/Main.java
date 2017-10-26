/*
Dawid Ćwik
Informatyka III gr. APB-OG
Algorytmy Numeryczne Zadanie 1
19.10.2017r.
*/

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Main {

    private static double[] arrayOrigin = new double[1001];
    private static double[] arrayModified = new double[1001];


    public static void main(String[] args) throws FileNotFoundException {

        count();

    }

    private static void count() throws FileNotFoundException {
        PrintWriter zapis;
        PrintWriter zapis2;
        PrintWriter zapis3;
        PrintWriter zapis4;
        double[] mainFront = new double[101];
        int i = 0;

        for (int x = 5; x<= 50; x = x+5) {
            String file = "countMainFrontx_" + (int)x +  ".txt";
            String file2 = "countMainBackx_" + (int)x + ".txt";
            String file3 = "countModifFrontx_" + (int)x + ".txt";
            String file4 = "countModifBackx_" + (int)x + ".txt";
            zapis = new PrintWriter(file);
            zapis2 = new PrintWriter(file2);
            zapis3 = new PrintWriter(file3);
            zapis4 = new PrintWriter(file4);

            for (int n = 10 ; n<=1000 ; n = n+10){

                putNumbersToArray(x, n);

                System.out.println("\n\t\t\tObliczam funkcje e^" + x);

                System.out.print("\nBezposrednio z biblioteki Math: ");
                System.out.println("\t\t" + Math.pow(Math.E,x));

                System.out.print("\nBezposrednio ze wzoru od przodu:");
                System.out.println("\t\t" + countMainFront(x, n));
                zapis.println(Math.abs(Math.pow(Math.E,x) - countMainFront(x, n)));

                System.out.print("Bezposrednio ze wzoru od tylu:");
                System.out.println("\t\t\t" + countMainBehind(x, n));
                zapis2.println(Math.abs(Math.pow(Math.E,x) - countMainBehind(x, n)));

                System.out.print("\nNa podstawie poprzedniego od przodu:");
                System.out.println("\t" + countModifiedFront(x, n));
                zapis3.println(Math.abs(Math.pow(Math.E,x) - countModifiedFront(x, n)));

                System.out.print("Na podstawie poprzedniego od tylu:");
                System.out.println("\t\t" + countModifiedBehind(x, n));
                zapis4.println(Math.abs(Math.pow(Math.E,x) - countModifiedBehind(x, n)));

            }


            check(x);

            zapis.close();
            zapis2.close();
            zapis3.close();
            zapis4.close();
        }



        System.out.println();
    }

    private static void putNumbersToArray(double x,double n) {
        for (double i = 0 ; i < n ; i++) {
            arrayOrigin[(int) i] = exponentiation(x, i)/factorial(i);
            if (i == 0){
                arrayModified[(int) i] = 1;
            } else {
                arrayModified[(int) i] = arrayModified[(int) i-1] * x / i;
            }
        }
    }

    private static double exponentiation(double x, double n) {
        double temp = x;

        if (n == 0) {
            return 1;
        }
        for (int i=1 ; i<n ; i++) {
            temp *= x;
        }

        return temp;
    }

    private static double factorial(double n) {
        if (n == 0) {
            return 1;
        }
        double fact = 1; // this  will be the result
        for (double i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private static double countMainFront(double x, double n) throws FileNotFoundException {
        double sum = 0;

            for (double i = 0; i < n; i++) {
                sum += arrayOrigin[(int) i];
            }

        return sum;
    }

    private static double countMainBehind(double x, double n) throws FileNotFoundException  {
        double sum = 0;

        for (double i=n-1 ; i>=0 ; i--) {
            sum += arrayOrigin[(int) i];
        }

        return sum;
    }

    private static double countModifiedFront(double x, double n) throws FileNotFoundException  {
        double sum = 0;

        for (double i=0 ; i<n ; i++) {
            sum += arrayModified[(int) i];
        }

        return sum;
    }

    private static double countModifiedBehind(double x, double n) throws FileNotFoundException  {
        double sum = 0;

        for (double i=n-1 ; i>=0 ; i--) {
            sum += arrayModified[(int) i];
        }

        return sum;
    }

    private static double check(double x) throws FileNotFoundException {
        double sum1 = 0, sum2 = 0;
        String file = "differenceInSumsx_" + (int)x + ".txt";
        String file2 = "differenceInArrayx_" + (int)x + ".txt";

        PrintWriter zapis = new PrintWriter(file);
        PrintWriter zapis2 = new PrintWriter(file2);
        double diff = 0;

        for (double i=0 ; i<=1000 ; i++) {
            diff = arrayOrigin[(int) i] - arrayModified[(int) i];
            if (diff<0){
                diff = diff*(-1);
            }
            zapis2.format("%10.30f%n",diff);
            sum1 += arrayOrigin[(int) i];
            sum2 += arrayModified[(int) i];
            zapis.format("%10.30f%n", Math.abs(sum1 - sum2));

        }
        System.out.println("\n\n");
        zapis.close();
        zapis2.close();
        return sum1;
    }
}
