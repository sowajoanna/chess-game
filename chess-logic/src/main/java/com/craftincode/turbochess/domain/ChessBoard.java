package com.craftincode.turbochess.domain;

public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        //todo ustaw pionki w sposob domyslny
    }

    private ChessBoard(Piece[][] board) {
        this.board = board;
    }

    public static ChessBoard getEmptyBoard(){
        return new ChessBoard(new Piece[8][8]);
    }

    public void performMove(Move move){
        // todo przesuń pionek zgodnie z move
    }

    public void setPiece(Piece piece, Position position){
        board[position.getRow()][position.getColumn()] = piece;
    }

    public Piece getPiece(Position position){
        return board[position.getRow()][position.getColumn()];
    }
}
