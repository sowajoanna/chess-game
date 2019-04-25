package com.craftincode.turbochess.domain;

public class Piece {
    Integer pieceId;
    PieceType type;
    PieceColor color;

    public Piece(Integer pieceId, PieceType type, PieceColor color) {
        this.pieceId = pieceId;
        this.type = type;
        this.color = color;
    }

    public Integer getPieceId() {
        return pieceId;
    }

    public void setPieceId(Integer pieceId) {
        this.pieceId = pieceId;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }
}
