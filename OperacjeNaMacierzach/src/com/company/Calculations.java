/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */


package com.company;

import com.company.Types.MyDouble;
import com.company.Types.MyFloat;
import com.company.Types.MyType;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Calculations {

    private int size;

    private MyMatrix<MyDouble> Ad;
    private MyMatrix<MyDouble> Bd;
    private MyMatrix<MyDouble> Cd;

    private MyMatrix<MyFloat> Af;
    private MyMatrix<MyFloat> Bf;
    private MyMatrix<MyFloat> Cf;

    private MyMatrix<MyType> Am;
    private MyMatrix<MyType> Bm;
    private MyMatrix<MyType> Cm;

    private MyMatrix<MyDouble> Xd;
    private MyMatrix<MyFloat> Xf;
    private MyMatrix<MyType> Xm;


    public Calculations(int size) {
        this.size = size;
        this.Ad = DataRetriever.readFromFileSaveToMatrix("MatrixA.txt", size);
        this.Bd = DataRetriever.readFromFileSaveToMatrix("MatrixB.txt", size);
        this.Cd = DataRetriever.readFromFileSaveToMatrix("MatrixC.txt", size);
        this.Xd = DataRetriever.readFromFileSaveToVector("Vector.txt", size);

        this.Af = convertMatrixToFloat(this.Ad);
        this.Bf = convertMatrixToFloat(this.Bd);
        this.Cf = convertMatrixToFloat(this.Cd);
        this.Xf = convertVectorToFloat(this.Xd);

        this.Am = convertMatrixToMyType(this.Ad);
        this.Bm = convertMatrixToMyType(this.Bd);
        this.Cm = convertMatrixToMyType(this.Cd);
        this.Xm = convertVectorToMyType(this.Xd);
    }

    public void prepareMatrix() {
        Ad = DataRetriever.readFromFileSaveToMatrix("MatrixA.txt", size);
        Bd = DataRetriever.readFromFileSaveToMatrix("MatrixB.txt", size);
        Cd = DataRetriever.readFromFileSaveToMatrix("MatrixC.txt", size);
        Xd = DataRetriever.readFromFileSaveToVector("Vector.txt", size);

        Af = convertMatrixToFloat(Ad);
        Bf = convertMatrixToFloat(Bd);
        Cf = convertMatrixToFloat(Cd);
        Xf = convertVectorToFloat(Xd);

        Am = convertMatrixToMyType(Ad);
        Bm = convertMatrixToMyType(Bd);
        Cm = convertMatrixToMyType(Cd);
        Xm = convertVectorToMyType(Xd);
    }

    public void count() throws FileNotFoundException {
        MyMatrix result = null;
        long start;
        long elapsedTime;
        ArrayList<Long> elapsedTimes = new ArrayList<>();

//----------------------------------------------------------------------------
        //A*X
        //double
        System.out.println("AX");
        System.out.println("double");
        result = countTimeForAX(elapsedTimes, Ad, Xd);
        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "AXdouble");
        DataRetriever.printMatrixToFile(size, result, "resultAXdouble");

        //float
        System.out.println("float");
        elapsedTimes.clear();
        result = countTimeForAX(elapsedTimes, Af, Xf);
        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "AXfloat");
        DataRetriever.printMatrixToFile(size, result, "resultAXfloat");

        //mytype
//        System.out.println("mytype");
//        elapsedTimes.clear();
//        result = countTimeForAX(elapsedTimes, Am, Xm);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "AXmytype");
//        DataRetriever.printMatrixMyTypeToFile(size, result, "resultAXmyType");


        //(A+B+C)*X
        //double
        System.out.println("ABCX");
        System.out.println("double");
        elapsedTimes.clear();
        result = countTimeForABC_X(elapsedTimes, Ad, Bd, Cd, Xd);
        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "ABCXdouble");
        DataRetriever.printMatrixToFile(size, result, "resultABCXdouble");

        //float
        System.out.println("float");
        elapsedTimes.clear();
        result = countTimeForABC_X(elapsedTimes, Af, Bf, Cf, Xf);
        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "ABCXfloat");
        DataRetriever.printMatrixToFile(size, result, "resultABCXfloat");

        //mytype
//        System.out.println("mytype");
//        elapsedTimes.clear();
//        result = countTimeForABC_X(elapsedTimes, Am, Bm, Cm, Xm);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "ABCXmytype");
//        DataRetriever.printMatrixMyTypeToFile(size, result, "resultABCXmyType");


        //A*(B*C)
        //double
//        System.out.println("ABC");
//        System.out.println("double");
//        elapsedTimes.clear();
//        result = countTimeForABC(elapsedTimes, Ad, Bd, Cd);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "ABC_double");
//
//
//        //float
//        System.out.println("float");
//        elapsedTimes.clear();
//        result = countTimeForABC(elapsedTimes, Af, Bf, Cf);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "ABC_float");
//        DataRetriever.printMatrixToFile(1, sumUp(result), "resultABCfloat");


        //mytype
//        System.out.println("mytype");
//        elapsedTimes.clear();
//        result = countTimeForABC(elapsedTimes, Am, Bm, Cm);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "ABC_mytype");


//-----------------------------------------------------------------------------


        System.out.println("Gausse");
        //Gauss z czesciowym wyborem
        //double
        System.out.println("czesc");
        System.out.println("double");
        elapsedTimes.clear();
        start = System.nanoTime();
        result = gaussWithRowChoice(Ad, Xd);
        elapsedTime = System.nanoTime() - start;
        elapsedTimes.add(elapsedTime);
        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "partialDouble");
        DataRetriever.printMatrixToFile(size, result, "resultPartialDouble");


        //float
        System.out.println("float");
        elapsedTimes.clear();
        start = System.nanoTime();
        result = gaussWithRowChoice(Af, Xf);
        elapsedTime = System.nanoTime() - start;
        elapsedTimes.add(elapsedTime);
        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "partialFloat");
        DataRetriever.printMatrixToFile(size, result, "resultPartialFloat");


        //mytype
//        System.out.println("mytype");
//        elapsedTimes.clear();
//        start = System.nanoTime();
//        result = gaussWithRowChoice(Am, Xm);
//        elapsedTime = System.nanoTime() - start;
//        elapsedTimes.add(elapsedTime);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "partialMyType");
//        DataRetriever.printMatrixMyTypeToFile(size, result, "resultPartialMyType");


        //bez wyboru
        //double
//        System.out.println("BEZ");
//        System.out.println("double");
//        elapsedTimes.clear();
//        start = System.nanoTime();
//        result = gaussWithoutChoice(Ad, Xd);
//        elapsedTime = System.nanoTime() - start;
//        elapsedTimes.add(elapsedTime);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "withoutDouble");
//        DataRetriever.printMatrixToFile(size, result, "resultBaseDouble");
////        float
//        System.out.println("float");
//        elapsedTimes.clear();
//        start = System.nanoTime();
//        result = gaussWithoutChoice(Af, Xf);
//        elapsedTime = System.nanoTime() - start;
//        elapsedTimes.add(elapsedTime);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "withoutFloat");
//        DataRetriever.printMatrixToFile(size, result, "resultBaseFloat");

        //mytype
//        System.out.println("mytype");
//        elapsedTimes.clear();
//        start = System.nanoTime();
//        result = gaussWithoutChoice(Am, Xm);
//        elapsedTime = System.nanoTime() - start;
//        elapsedTimes.add(elapsedTime);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "withoutMyType");


        //full
        //double
        System.out.println("full");
        System.out.println("double");
        elapsedTimes.clear();
        start = System.nanoTime();
        result = gaussWithFullChoice(Ad, Xd);
        elapsedTime = System.nanoTime() - start;
        elapsedTimes.add(elapsedTime);
        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "fullDouble");
        DataRetriever.printMatrixToFile(size, result, "resultFullDouble");


        //float
        System.out.println("float");
        elapsedTimes.clear();
        start = System.nanoTime();
        result = gaussWithFullChoice(Af, Xf);
        elapsedTime = System.nanoTime() - start;
        elapsedTimes.add(elapsedTime);
        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "fullFloat");
        DataRetriever.printMatrixToFile(size, result, "resultFullFloat");


        //mytype
//        elapsedTimes.clear();
//        System.out.println("mytype");
//        start = System.nanoTime();
//        result = gaussWithFullChoice(Am, Xm);
//        elapsedTime = System.nanoTime() - start;
//        elapsedTimes.add(elapsedTime);
//        DataRetriever.printTimeToFile(size, averageOfTime(elapsedTimes), "fullMyType");


    }


    // ****** Liczenie czasu ******
    private MyMatrix countTimeForAX(ArrayList<Long> elapsedTimes, MyMatrix A, MyMatrix X) {
        long start;
        MyMatrix result = null;
        long elapsedTime;
        for (int i = 0; i < 200; i++) {
            start = System.nanoTime();
            result = multiplyWithVector(A, X);
            elapsedTime = System.nanoTime() - start;
            elapsedTimes.add(elapsedTime);
        }
        return result;
    }

    private MyMatrix countTimeForABC(ArrayList<Long> elapsedTimes, MyMatrix A, MyMatrix B, MyMatrix C) {
        long start;
        MyMatrix result = null;
        long elapsedTime;
        for (int i = 0; i < 200; i++) {
            start = System.nanoTime();
            result = multiplyThreeMatrixs(A, B, C);
            elapsedTime = System.nanoTime() - start;
            elapsedTimes.add(elapsedTime);
        }
        return result;
    }

    private MyMatrix countTimeForABC_X(ArrayList<Long> elapsedTimes, MyMatrix A, MyMatrix B, MyMatrix C, MyMatrix X) {
        long start;
        MyMatrix result = null;
        long elapsedTime;
        for (int i = 0; i < 200; i++) {
            start = System.nanoTime();
            result = sumMatrixAndMultiplyWithVector(A, B, C, X);
            elapsedTime = System.nanoTime() - start;
            elapsedTimes.add(elapsedTime);
        }
        return result;
    }

    //  ***** KONWERTOWANIE MACIERZY NA INNE TYPY *****
    private MyMatrix<MyFloat> convertMatrixToFloat(MyMatrix matrix) {
        MyMatrix<MyFloat> result = new MyMatrix<>(size, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.setMatrixElement(i, j, new MyFloat(matrix.getMatrixElement(i, j).floatValue()));
            }
        }
        return result;
    }

    public MyMatrix<MyType> convertMatrixToMyType(MyMatrix m) {
        MyMatrix<MyType> result = new MyMatrix<>(size, size);
        for (int i = 0; i < size; i++) {
            for (int x = 0; x < size; x++) {
                result.setMatrixElement(i, x, new MyType(m.getMatrixElement(i, x).doubleValue()));
            }
        }
        return result;
    }

    private MyMatrix<MyFloat> convertVectorToFloat(MyMatrix vector) {
        MyMatrix<MyFloat> result = new MyMatrix<>(size);
        for (int i = 0; i < size; i++) {
            result.setVectorElement(i, new MyFloat(vector.getVectorElement(i).floatValue()));
        }
        return result;
    }

    private MyMatrix<MyType> convertVectorToMyType(MyMatrix vector) {
        MyMatrix<MyType> result = new MyMatrix<>(size);
        for (int i = 0; i < size; i++) {
            result.setVectorElement(i, new MyType(vector.getVectorElement(i).doubleValue()));
        }
        return result;
    }

    //  ***** DRUKOWANIE MACIERZY *****
    public void printMatrix(MyMatrix tab) {
        for (int row = 0; row < size; row++) {
            System.out.print("[");
            for (int col = 0; col < size; col++) {
                System.out.print(tab.getMatrixElement(row, col));
                if (size - 1 != col)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public void printVector(MyMatrix tab) {
        for (int col = 0; col < size; col++) {
            System.out.println(tab.getVectorElement(col));
        }
        System.out.println();
    }

    public MyMatrix sumUp(MyMatrix A) {
        MyMatrix result = new MyMatrix(size);
        result.setTemp(A.zeroElement(A.getMatrixElement(0, 0)));
        for (int i = 0; i < size; i++) {
            result.setTemp(A.zeroElement(A.getMatrixElement(0, 0)));
            for (int x = 0; x < size; x++) {
                result.setTemp(A.addElement(result.getTemp(), A.getMatrixElement(i, x)));
                result.setVectorElement(i, result.getTemp());
            }
        }
        return result;
    }

    public double averageOfTime(ArrayList<Long> time) {
        Long sum = Long.valueOf(0);
        for (Long t : time) {
            sum += t;
        }

        return sum.doubleValue() / time.size();
    }

    //  ***** DZIALANIA *****
    //  *** zwykle dzialania ***
    public MyMatrix sumMatrixs(MyMatrix A, MyMatrix B) {
        MyMatrix result = new MyMatrix<>(size, size);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                result.setMatrixElement(i, j, A.addElement(A.getMatrixElement(i, j), B.getMatrixElement(i, j)));
            }
        }
        return result;
    }

    public MyMatrix multiplyWithVector(MyMatrix A, MyMatrix X) {
        MyMatrix result = new MyMatrix(size);
        result.setTemp(A.zeroElement(A.getMatrixElement(0, 0)));
        for (int i = 0; i < size; i++) {
            result.setTemp(A.zeroElement(A.getMatrixElement(0, 0)));
            for (int x = 0; x < size; x++) {
                result.setTemp(A.addElement(
                        result.getTemp(), A.multiplyElement(
                                A.getMatrixElement(i, x), X.getVectorElement(x)
                        ))
                );
                result.setVectorElement(i, result.getTemp());
            }
        }
        return result;
    }

    public MyMatrix multiplyWithMatrix(MyMatrix A, MyMatrix B) {
        MyMatrix result = new MyMatrix(size, size);
        for (int i = 0; i < size; i++) {
            for (int x = 0; x < size; x++) {
                result.setMatrixElement(i, x, A.zeroElement(A.getMatrixElement(i, x)));

                for (int j = 0; j < size; j++) {
                    result.setMatrixElement(i, x, (A.addElement(result.getMatrixElement(i, x), B.multiplyElement(A.getMatrixElement(i, j), B.getMatrixElement(j, x)))));
                }
            }
        }
        return result;
    }

    public MyMatrix sumMatrixAndMultiplyWithVector(MyMatrix A, MyMatrix B, MyMatrix C, MyMatrix X) {
        MyMatrix result = new MyMatrix(size, size);

        result = sumMatrixs(A, B);
        result = sumMatrixs(result, C);
        result = multiplyWithVector(result, X);

        return result;
    }

    public MyMatrix multiplyThreeMatrixs(MyMatrix A, MyMatrix B, MyMatrix C) {
        MyMatrix result = new MyMatrix(size, size);

        result = multiplyWithMatrix(B, C);
        result = multiplyWithMatrix(result, A);
        return result;
    }

    //  ***** ALGORYTM GAUSSA *****
    // *** Czesciowy wybor ***
    public MyMatrix gaussWithRowChoice(MyMatrix A, MyMatrix bVector) {
        makeRowEchelonMatrixWithRowChoice(A, bVector);
        return countXVector(A, bVector);
    }

    public void makeRowEchelonMatrixWithRowChoice(MyMatrix A, MyMatrix VectorB) {
        for (int k = 0; k < size; k++) {
            int rowWithDiagonalNumber = k;
            int rowNumberWithMaxNumberInColumn = findRowWithMaxNumberInColumnUnderDiagonal(A, k);

            if (rowNumberWithMaxNumberInColumn != rowWithDiagonalNumber) {
                swapRows(rowWithDiagonalNumber, rowNumberWithMaxNumberInColumn, A, VectorB);
            }
            makeRowEchelon(A, VectorB, k);
        }
    }

    public int findRowWithMaxNumberInColumnUnderDiagonal(MyMatrix A, int columnNumber) {
        int rowNumberWithMaxNumberInColumn = columnNumber;
        int firstRowUnderDiagonal = columnNumber + 1;
        for (int i = firstRowUnderDiagonal; i < size; i++) {
            if (A.lessElement(A.getMatrixElement(rowNumberWithMaxNumberInColumn, columnNumber), A.getMatrixElement(i, columnNumber)))
                ;
            {
                rowNumberWithMaxNumberInColumn = i;
            }
        }
        return rowNumberWithMaxNumberInColumn;
    }

    public MyMatrix swapRows(int rowWithDiagonalNumber, int rowNumberWithMaxNumber, MyMatrix A, MyMatrix bVector) {
        MyMatrix tempRow = new MyMatrix(size);
        for (int i = 0; i < size; i++) {
            tempRow.setTemp(A.getMatrixElement(rowWithDiagonalNumber, i));
            A.setMatrixElement(rowWithDiagonalNumber, i, A.getMatrixElement(rowNumberWithMaxNumber, i));
            A.setMatrixElement(rowNumberWithMaxNumber, i, tempRow.getTemp());
        }

        tempRow.setTemp(bVector.getVectorElement(rowWithDiagonalNumber));
        bVector.setVectorElement(rowWithDiagonalNumber, bVector.getVectorElement(rowNumberWithMaxNumber));
        bVector.setVectorElement(rowNumberWithMaxNumber, tempRow.getTemp());

        return bVector;
    }

    public void makeRowEchelon(MyMatrix A, MyMatrix VectorB, int k) {
        for (int i = k + 1; i < size; i++) {
            A.setTemp(A.divideElement(A.getMatrixElement(i, k), A.getMatrixElement(k, k)));
            for (int j = 0; j < size; j++) {
                A.setMatrixElement(i, j,
                        A.subtractElement(A.getMatrixElement(i, j),
                                A.multiplyElement(A.getMatrixElement(k, j), A.getTemp())
                        )
                );
            }
            VectorB.setVectorElement(i,
                    VectorB.subtractElement(VectorB.getVectorElement(i),
                            VectorB.multiplyElement(VectorB.getVectorElement(k), A.getTemp())));
        }
    }

    public MyMatrix countXVector(MyMatrix A, MyMatrix bVector) {
        MyMatrix xVector = new MyMatrix(size);
        for (int i = size - 1; i >= 0; i--) {
            xVector.setVectorElement(i,
                    A.zeroElement(A.getMatrixElement(0, 0))
            );
        }
        for (int i = size - 1; i >= 0; i--) {
            xVector.setTemp(A.zeroElement(A.getMatrixElement(0, 0)));
            for (int x = i + 1; x < size; x++) {
                xVector.setTemp(xVector.addElement(
                        xVector.getTemp(), A.multiplyElement(
                                A.getMatrixElement(i, x), xVector.getVectorElement(x)
                        )
                ));
            }
            xVector.setVectorElement(i,
                    xVector.divideElement(
                            xVector.subtractElement(bVector.getVectorElement(i), xVector.getTemp())
                            , A.getMatrixElement(i, i)
                    )
            );
        }
        return xVector;
    }

    public MyMatrix gaussWithoutChoice(MyMatrix A, MyMatrix bVector) {
        makeRowEchelonMatrix(A, bVector);
        return countXVector(A, bVector);
    }

    public void makeRowEchelonMatrix(MyMatrix A, MyMatrix VectorB) {

        for (int k = 0; k < size; k++) {
            for (int i = k + 1; i < size; i++) {
                makeRowEchelon(A, VectorB, k);
            }
        }
    }

    public MyMatrix gaussWithFullChoice(MyMatrix A, MyMatrix bVector) {
        int[] xVectorNumberChangeTable = new int[size];
        for (int i = 0; i < size; i++) {
            xVectorNumberChangeTable[i] = i;
        }
        makeRowEchelonMatrixWithFullChoice(A, bVector, xVectorNumberChangeTable);


        return countModifiedXVector(A, bVector, xVectorNumberChangeTable);

    }

    public void makeRowEchelonMatrixWithFullChoice(MyMatrix A, MyMatrix bVector, int[] xVectorNumberChangeTable) {
        for (int k = 0; k < size; k++) {

            int rowNumberWithDiagonalPoint = k;

            RowAndColumnContainer container = new RowAndColumnContainer(k, k);


            findRowAndColumnWithMaxElementInMatrix(A, rowNumberWithDiagonalPoint, container);
            if (container.getMax_row() != rowNumberWithDiagonalPoint) {
                swapRows(rowNumberWithDiagonalPoint, container.getMax_row(), A, bVector);
            }

            if (container.getMax_column() != rowNumberWithDiagonalPoint) {
                swapColumns(A, rowNumberWithDiagonalPoint, container.getMax_column(), xVectorNumberChangeTable);
            }

            makeRowEchelon(A, bVector, k);
        }
    }

    public MyMatrix countModifiedXVector(MyMatrix A, MyMatrix bVector, int[] xVectorNumberChangeTable) {
        MyMatrix xVector = countXVector(A, bVector);

        for (int i = 0; i < xVectorNumberChangeTable.length; i++) {
            for (int x = i + 1; x < xVectorNumberChangeTable.length; x++) {
                if (i == xVectorNumberChangeTable[x]) {
                    xVector.setTemp(xVector.getVectorElement(i));
                    xVector.setVectorElement(i, xVector.getVectorElement(x));
                    xVector.setVectorElement(x, xVector.getTemp());
                    xVectorNumberChangeTable[x] = xVectorNumberChangeTable[i];
                    xVectorNumberChangeTable[i] = i;
                }
            }
        }
        return xVector;
    }

    public void findRowAndColumnWithMaxElementInMatrix(MyMatrix A, int rowNumberWithDiagonalPoint, RowAndColumnContainer cont) {
        int columnNumberWithDiagonalPoint = rowNumberWithDiagonalPoint;

        for (int i = rowNumberWithDiagonalPoint; i < size; i++) {
            for (int j = columnNumberWithDiagonalPoint; j < size; j++) {
                if (A.lessElement(A.getMatrixElement(cont.getMax_row(), cont.getMax_column()), A.getMatrixElement(i, j))) {
                    cont.setMax_row(i);
                    cont.setMax_column(j);

                }
            }
        }
    }

    public void swapColumns(MyMatrix A, int columnNumberWithDiagonalPoint, int columnNumberWithMaxNumber, int[] xVector) {
        int tempValue;
        for (int i = 0; i < size; i++) {
            A.setTemp(A.getMatrixElement(i, columnNumberWithDiagonalPoint));
            A.setMatrixElement(i, columnNumberWithDiagonalPoint, A.getMatrixElement(i, columnNumberWithMaxNumber));
            A.setMatrixElement(i, columnNumberWithMaxNumber, A.getTemp());
        }

        tempValue = xVector[columnNumberWithDiagonalPoint];
        xVector[columnNumberWithDiagonalPoint] = xVector[columnNumberWithMaxNumber];
        xVector[columnNumberWithMaxNumber] = tempValue;
    }


}
