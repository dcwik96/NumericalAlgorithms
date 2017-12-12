package com.company;

import java.util.ArrayList;
import java.util.List;

public class Flashcard {

    private int p1Start;
    private int p2Start;

    private int numberOfFields;
    private List<Integer> fields = new ArrayList<>();

    public Flashcard(int p1Start, int p2Start, int numberOfFields) {
        this.numberOfFields = numberOfFields * 2 + 1;
        createFields();
        this.p1Start = setStartPosition(p1Start);;
        this.p2Start = setStartPosition(p2Start);;
    }

    private int setStartPosition(int place) {
        if (place < 0 ) {
            return fields.size() + place;
        }
        else return place;
    }

    private void createFields() {
        for (int i = 0; i < this.numberOfFields; i++) {
            this.fields.add(i);
        }
    }

    public int getP1Start() {
        return p1Start;
    }

    public int getP2Start() {
        return p2Start;
    }

    public int getNumberOfFields() {
        return numberOfFields;
    }

    public List<Integer> getFields() {
        return fields;
    }

    public void setP1Start(int p1Start) {
        this.p1Start = p1Start;
    }

    public void setP2Start(int p2Start) {
        this.p2Start = p2Start;
    }

    public void setNumberOfFields(int numberOfFields) {
        this.numberOfFields = numberOfFields;
    }

    public void setFields(List<Integer> fields) {
        this.fields = fields;
    }
}
