package com.craftincode.turbochess.domain;

import com.craftincode.turbochess.logic.InvalidPositionString;

public class Position {
    private int row, column;

    public Position(String position) { // "A2"
        char[] array = position.toUpperCase().toCharArray();
        this.row = 8 - array[1] + 48;
        this.column = array[0] - 65;
        if(column<0 || column > 7 || row < 0 || row > 7){
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
