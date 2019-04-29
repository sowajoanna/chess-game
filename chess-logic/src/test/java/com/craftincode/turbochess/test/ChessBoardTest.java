package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.*;
import org.junit.Test;

import static com.craftincode.turbochess.domain.PieceColor.*;
import static com.craftincode.turbochess.domain.PieceType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ChessBoardTest {
    @Test
    public void constructor_noParams_returnsDefaultBoard(){
        ChessBoard chessBoard = new ChessBoard();
        assertEquals(new Piece(PAWN, BLACK), chessBoard.getPiece(new Position("E7")));
        assertEquals(new Piece(KNIGHT, WHITE), chessBoard.getPiece(new Position("B1")));
        assertEquals(new Piece(ROOK, BLACK), chessBoard.getPiece(new Position("H8")));
    }

    @Test
    public void getPiece_positionA8_returnsBlackRook(){
        ChessBoard chessBoard = new ChessBoard();
        assertEquals(new Piece(ROOK, BLACK), chessBoard.getPiece(new Position("A8")));
    }

    @Test
    public void getPiece_positionD4_returnsNull(){
        ChessBoard chessBoard = new ChessBoard();
        assertNull(chessBoard.getPiece(new Position("D4")));
    }

    @Test
    public void performMove_fromB2ToB3(){
        ChessBoard chessBoard = new ChessBoard();
        Position fromPosition = new Position("B2");
        Position toPosition = new Position("B3");

        chessBoard.performMove(new Move(fromPosition, toPosition));

        assertEquals(new Piece(PAWN, WHITE), chessBoard.getPiece(toPosition));
        assertNull(chessBoard.getPiece(fromPosition));
    }
}
