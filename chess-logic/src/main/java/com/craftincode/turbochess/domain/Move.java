package com.craftincode.turbochess.domain;

public class Move {
//    private Integer moveId;
//    private Integer gameId;
//    private Integer pieceId;
//    private Integer playerId;
    private Position fromPosition;
    private Position toPosition;

    public Move(Position fromPosition, Position toPosition) {
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
    }

    public int verticalShift(){
        return fromPosition.getRow() - toPosition.getRow();
    }

    public int horizontalShift(){
        return fromPosition.getColumn() - toPosition.getColumn();
    }


    public Position getFromPosition() {
        return fromPosition;
    }

    public void setFromPosition(Position fromPosition) {
        this.fromPosition = fromPosition;
    }

    public Position getToPosition() {
        return toPosition;
    }

    public void setToPosition(Position toPosition) {
        this.toPosition = toPosition;
    }

    @Override
    public String toString() {
        return "Move{" +
                "fromPosition='" + fromPosition + '\'' +
                ", toPosition='" + toPosition + '\'' +
                '}';
    }
}
