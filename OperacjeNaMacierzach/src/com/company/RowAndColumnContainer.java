/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */

package com.company;

public class RowAndColumnContainer {
    int max_row;
    int max_column;

    public int getMax_row() {
        return max_row;
    }

    public void setMax_row(int max_row) {
        this.max_row = max_row;
    }

    public int getMax_column() {
        return max_column;
    }

    public void setMax_column(int max_column) {
        this.max_column = max_column;
    }

    public RowAndColumnContainer(int max_row, int max_column) {
        this.max_row = max_row;
        this.max_column = max_column;
    }
}
