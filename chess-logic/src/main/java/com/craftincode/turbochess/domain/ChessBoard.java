package com.craftincode.turbochess.domain;

public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        //todo
        // ustaw pionki w sposob domyslny
    }

    public void performMove(Move move){
        // todo przesuń pionek zgodnie z move
    }

    public Piece getPiece(Position position){
        return null; //todo
    }
}
