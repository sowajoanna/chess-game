package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.*;
import com.craftincode.turbochess.logic.KnightMoveValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class KnightMoveValidatorTest {

    private ChessBoard chessBoard ;
    @Before
    public void buildBoard(){
        chessBoard = ChessBoard.getEmptyBoard();

    }

    @Test
    public void isValid_MoveForwardBy1AndRightBy2_returnsTrue(){
        KnightMoveValidator knightMoveValidator = new KnightMoveValidator();
        Move move = new Move(new Position("B3"), new Position("D4"));
        Piece knight = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        chessBoard.getBoard()[5][1] = knight;
        assertTrue(knightMoveValidator.isValid(move,chessBoard));
    }

    @Test
    public void isValid_MoveForwardBy2AndLeftBy1_returnsTrue(){
        KnightMoveValidator knightMoveValidator = new KnightMoveValidator();
        Move move = new Move(new Position("B3"), new Position("A5"));
        Piece knight = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        chessBoard.getBoard()[5][1] = knight;
        assertTrue(knightMoveValidator.isValid(move,chessBoard));

    }

    @Test
    public void isValid_MoveBackwardBy1AndRightBy2_returnsTrue(){
        KnightMoveValidator knightMoveValidator = new KnightMoveValidator();
        Move move = new Move(new Position("B6"), new Position("D5"));
        Piece knight = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        chessBoard.getBoard()[2][1] = knight;
        assertTrue(knightMoveValidator.isValid(move,chessBoard));

    }

    @Test
    public void isValid_MoveBackwardBy2AndLeftBy1_returnsTrue(){
        KnightMoveValidator knightMoveValidator = new KnightMoveValidator();
        Move move = new Move(new Position("B6"), new Position("A4"));
        Piece knight = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        chessBoard.getBoard()[2][1] = knight;
        assertTrue(knightMoveValidator.isValid(move,chessBoard));
    }

    @Test
    public void isValid_MoveForwardByMoreThan2_returnsFalse(){
        KnightMoveValidator knightMoveValidator = new KnightMoveValidator();
        Move move = new Move(new Position("B1"), new Position("C4"));
        assertFalse(knightMoveValidator.isValid(move,chessBoard));
    }

    @Test
    public void isValid_MoveBackwardByMoreThan2_returnsFalse(){
        KnightMoveValidator knightMoveValidator = new KnightMoveValidator();
        Move move = new Move(new Position("B6"), new Position("A3"));
        Piece knight = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        chessBoard.getBoard()[2][1] = knight;
        assertFalse(knightMoveValidator.isValid(move,chessBoard));
    }

    @Test
    public void isValid_MoveCorrectButFriendlyPieceIsOnTargetPosition_returnsFalse(){
        KnightMoveValidator knightMoveValidator = new KnightMoveValidator();
        Move move = new Move(new Position("B8"), new Position("C6"));
        Piece friendlyPiece = new Piece(PieceType.PAWN, PieceColor.BLACK);
        chessBoard.getBoard()[2][2] = friendlyPiece;
        assertFalse(knightMoveValidator.isValid(move,chessBoard));
    }

    @Test
    public void isValid_MoveButOpponentPieceIsOnTargetPosition_returnsTrue(){
        KnightMoveValidator knightMoveValidator = new KnightMoveValidator();
        Move move = new Move(new Position("B8"), new Position("C6"));
        Piece friendlyPiece = new Piece(PieceType.PAWN, PieceColor.WHITE);
        chessBoard.getBoard()[2][2] = friendlyPiece;
        assertTrue(knightMoveValidator.isValid(move,chessBoard));

    }


}
