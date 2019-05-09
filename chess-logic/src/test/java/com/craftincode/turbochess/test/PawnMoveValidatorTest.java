package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.*;
import com.craftincode.turbochess.logic.MoveValidator;
import com.craftincode.turbochess.logic.PawnMoveValidator;
import org.junit.Before;
import org.junit.Test;

import static com.craftincode.turbochess.domain.PieceType.*;
import static com.craftincode.turbochess.domain.PieceColor.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PawnMoveValidatorTest {
    private static Piece whitePawn = new Piece(PAWN, WHITE);
    private static Piece blackPawn = new Piece(PAWN, BLACK);
    private ChessBoard board;

    @Before
    public void initializeBoard(){
        board = ChessBoard.getEmptyBoard();
    }

    @Test
    public void isValid_moveForwardBy1_returnsTrue() {
        board.setPiece(whitePawn, new Position("C2"));
        board.setPiece(null, new Position("C3"));
        Move moveForward = new Move(new Position("C2"),new Position("C3"));
        MoveValidator moveValidator = new PawnMoveValidator();
        assertTrue(moveValidator.isValid(moveForward,board));
    }

    @Test
    public void isValid_moveForwardBy2OnFirstMoveWhenNoOpponent_returnsTrue() {
        board.setPiece(whitePawn, new Position("C2"));
        board.setPiece(null, new Position("C3"));
        Move moveForward = new Move(new Position("C2"),new Position("C4"));
        MoveValidator moveValidator = new PawnMoveValidator();
        assertTrue(moveValidator.isValid(moveForward,board));
    }

    @Test
    public void isValid_moveForwardBy1WithOpponent_returnsFalse() {
        board.setPiece(whitePawn, new Position("C2"));
        board.setPiece(blackPawn, new Position("C3"));
        Move moveForward = new Move(new Position("C2"),new Position("C3"));
        MoveValidator moveValidator = new PawnMoveValidator();
        assertFalse(moveValidator.isValid(moveForward,board));
    }

    @Test
    public void isValid_moveForwardBy2ButAnotherPieceIsInTheWay_returnsFalse() {
        board.setPiece(whitePawn, new Position("C2"));
        board.setPiece(blackPawn, new Position("C4"));
        Move moveForward = new Move(new Position("C2"),new Position("C4"));
        MoveValidator moveValidator = new PawnMoveValidator();
        assertFalse(moveValidator.isValid(moveForward,board));
    }


    @Test
    public void isValid_moveForwardBy2OnAnotherMove_returnsFalse() {
        fail();
    }


    @Test
    public void isValid_moveDiagonallyBy1OnAttack_returnsTrue() {
        fail();
    }


    @Test
    public void isValid_moveBackwards_returnsFalse() {
        fail();
    }


}
