package com.craftincode.turbochess.domain;

import com.craftincode.turbochess.commons.InvalidPositionString;

public class Position {
    private int row, column;

    public Position(String position) { // A2
        char[] coords = position.toUpperCase().toCharArray();
        column = coords[0] - 'A';
        row = 8 - (coords[1] - '0');
        if(column <0 || column > 7 || row < 0 || row > 7){
            throw new InvalidPositionString();
        }
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
