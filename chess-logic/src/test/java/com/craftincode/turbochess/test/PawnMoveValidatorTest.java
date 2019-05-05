package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.*;
import com.craftincode.turbochess.logic.PawnMoveValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertFalse;

public class PawnMoveValidatorTest {
    @Test
    public void isValid_moveForwardBy1_returnsTrue() {
        Move move = new Move(new Position("A7"), new Position(("A6")));
        ChessBoard chessBoard = new ChessBoard();
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();
        assertTrue(pawnMoveValidator.isValid(move, chessBoard));

    }

    @Test
    public void isValid_moveForwardBy2OnFirstMove_returnsTrue() {
        Move move = new Move(new Position("A7"), new Position(("A5")));
        ChessBoard chessBoard = new ChessBoard();
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();
        assertTrue(pawnMoveValidator.isValid(move, chessBoard));
    }
    ChessBoard chessBoard = new ChessBoard();
    @Test
    public void isValid_moveForwardBy1ButAnotherPieceIsInTheWay_returnsFalse() {
        Move move = new Move(new Position("A2"), new Position(("A3")));
        ChessBoard chessBoard = new ChessBoard();
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();
        Piece pawn = new Piece(PieceType.PAWN, PieceColor.WHITE);
        chessBoard.getBoard()[5][0] = pawn;

        assertFalse(pawnMoveValidator.isValid(move, chessBoard));
    }

   @Test
    public void isValid_moveForwardBy2ButAnotherPieceIsInTheWay_returnsFalse() {
       Move move = new Move(new Position("A2"), new Position(("A4")));
       ChessBoard chessBoard = new ChessBoard();
       PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();
       Piece pawn = new Piece(PieceType.PAWN, PieceColor.WHITE);
       chessBoard.getBoard()[4][0] = pawn;

       assertFalse(pawnMoveValidator.isValid(move, chessBoard));
    }


    @Test
    public void isValid_moveForwardBy2OnAnotherMove_returnsFalse() {
        Move move = new Move(new Position("B4"), new Position(("B6")));
        ChessBoard chessBoard = new ChessBoard();
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();
        Piece pawn = new Piece(PieceType.PAWN, PieceColor.WHITE);
        chessBoard.getBoard()[4][1] = pawn;

        assertFalse(pawnMoveValidator.isValid(move, chessBoard));
    }


    @Test
    public void isValid_moveDiagonallyBy1OnAttack_returnsTrue() {
        Move move = new Move(new Position("A2"), new Position(("B3")));
        ChessBoard chessBoard = new ChessBoard();
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();
        Piece pawn = new Piece(PieceType.PAWN, PieceColor.BLACK);
        chessBoard.getBoard()[5][1] = pawn;

        assertTrue(pawnMoveValidator.isValid(move, chessBoard));
    }


    @Test
    public void isValid_moveBackwards_returnsFalse() {
        Piece pawn = new Piece(PieceType.PAWN, PieceColor.BLACK);
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.getBoard()[4][0] = pawn;
        Move move = new Move(new Position("A4"), new Position(("A5")));
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();
        assertFalse(pawnMoveValidator.isValid(move, chessBoard));
    }


}
