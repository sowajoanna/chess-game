package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.ChessBoard;
import com.craftincode.turbochess.domain.Piece;
import com.craftincode.turbochess.domain.PieceColor;
import com.craftincode.turbochess.domain.PieceType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChessBoardTest {
    @Test
    public void constructor_noParams_returnsDefaultBoard(){
        ChessBoard chessBoard = new ChessBoard();
        Piece blackRook = new Piece(PieceType.ROOK, PieceColor.BLACK);

        assertEquals(blackRook, chessBoard.getBoard()[0][0]);

//        assertEquals(new Piece(PieceType.ROOK, PieceColor.BLACK), chessBoard[0][0]);

    }
}
