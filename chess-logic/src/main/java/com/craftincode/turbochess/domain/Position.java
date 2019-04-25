package com.craftincode.turbochess.domain;

public class Position {
    private int row, colum;

    public Position(String position) { // "A2"
        //todo convert string postion to ints (row, column)
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColum() {
        return colum;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }
}
