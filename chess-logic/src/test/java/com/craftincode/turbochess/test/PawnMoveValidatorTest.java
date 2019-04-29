package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.ChessBoard;
import com.craftincode.turbochess.domain.Move;
import com.craftincode.turbochess.domain.Position;
import com.craftincode.turbochess.logic.PawnMoveValidator;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.fail;

public class PawnMoveValidatorTest {
    @Test
    public void isValid_moveForwardBy1_returnsTrue() {
        ChessBoard chessBoard = new ChessBoard();
        Move move = new Move(new Position("C7"), new Position("C6"));
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

        assertTrue(pawnMoveValidator.isValid(move, chessBoard));
    }

    @Test
    public void isValid_moveForwardBy2OnFirstMove_returnsTrue() {
        ChessBoard chessBoard = new ChessBoard();
        Move move = new Move(new Position("C7"), new Position("C5"));
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

        assertTrue(pawnMoveValidator.isValid(move, chessBoard));
    }

    @Test
    public void isValid_moveForwardBy1ButAnotherPieceIsInTheWay_returnsFalse() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.performMove(new Move(new Position("A8"), new Position("D3")));
        Move move = new Move(new Position("D2"), new Position("D3"));
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

        assertFalse(pawnMoveValidator.isValid(move, chessBoard));
    }

    @Test
    public void isValid_moveForwardBy2ButAnotherPieceIsInTheWay_returnsFalse() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.performMove(new Move(new Position("A8"), new Position("D4")));
        Move move = new Move(new Position("D2"), new Position("D4"));
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

        assertFalse(pawnMoveValidator.isValid(move, chessBoard));
    }


//    @Test
//    public void isValid_moveForwardBy2OnAnotherMove_returnsFalse() {
//        fail();
//    }


    @Test
    public void isValid_moveDiagonallyBy1OnAttack_returnsTrue() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.performMove(new Move(new Position("A8"), new Position("D3")));
        Move move = new Move(new Position("C2"), new Position("D3"));
        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

        assertTrue(pawnMoveValidator.isValid(move, chessBoard));
    }


//    @Test
//    public void isValid_moveBackwards_returnsFalse() {
//        fail();
//    }


}
