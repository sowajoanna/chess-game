package com.craftincode.turbochess.domain;

public class Position {
    private int row, column;

    public Position(String position) { // "A2"
        char columnSymbol = position.toUpperCase().charAt(0);
        char rowSymbol = position.charAt(1);
        int rowNumber = rowSymbol - '0';

        this.column = columnSymbol - 'A';
        this.row = Math.abs(rowNumber - 8);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
