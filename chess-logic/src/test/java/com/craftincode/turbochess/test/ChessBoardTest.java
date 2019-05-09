package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.*;
import org.junit.Before;
import org.junit.Test;

import static com.craftincode.turbochess.domain.PieceColor.*;
import static com.craftincode.turbochess.domain.PieceType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ChessBoardTest {
    private  ChessBoard chessBoard;
    @Before
    public void createDefaultChessBoard(){
        chessBoard = ChessBoard.getDefaultBoard();
    }

    @Test
    public void constructor_noParams_returnsDefaultBoard(){
        assertEquals(new Piece(PAWN, BLACK), chessBoard.getPiece(new Position("E7")));
        assertEquals(new Piece(KNIGHT, WHITE), chessBoard.getPiece(new Position("B1")));
        assertEquals(new Piece(ROOK, BLACK), chessBoard.getPiece(new Position("H8")));
    }

    @Test
    public void getPiece_positionA8_returnsBlackRook(){
        assertEquals(new Piece(ROOK, BLACK), chessBoard.getPiece(new Position("A8")));
    }

    @Test
    public void getPiece_positionD4_returnsNull(){
        assertNull(chessBoard.getPiece(new Position("D4")));
    }

    @Test
    public void performMove_fromB2ToB3(){
        Position fromPosition = new Position("B2");
        Position toPosition = new Position("B3");

        chessBoard.performMove(new Move(fromPosition, toPosition));

        assertEquals(new Piece(PAWN, WHITE), chessBoard.getPiece(toPosition));
        assertNull(chessBoard.getPiece(fromPosition));
    }
}
