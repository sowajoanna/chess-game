package com.craftincode.turbochess.domain;

import static com.craftincode.turbochess.domain.PieceType.*;
import static com.craftincode.turbochess.domain.PieceColor.*;

public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        board[0][0] = board[0][7] = new Piece(ROOK, BLACK);
        board[0][1] = board[0][6] = new Piece(KNIGHT, BLACK);
        board[0][2] = board[0][5] = new Piece(BISHOP, BLACK);
        board[0][3] = new Piece(KING, BLACK);
        board[0][4] = new Piece(QUEEN, BLACK);

        for (int i = 0; i < board[1].length; i++) {
            board[1][i] = new Piece(PAWN, BLACK);
        }

        board[7][0] = board[7][7] = new Piece(ROOK, WHITE);
        board[7][1] = board[7][6] = new Piece(KNIGHT, WHITE);
        board[7][2] = board[7][5] = new Piece(BISHOP, WHITE);
        board[7][3] = new Piece(KING, WHITE);
        board[7][4] = new Piece(QUEEN, WHITE);

        for (int i = 0; i < board[6].length; i++) {
            board[6][i] = new Piece(PAWN, WHITE);
        }
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
