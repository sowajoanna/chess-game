package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.ChessBoard;
import com.craftincode.turbochess.domain.Move;
import com.craftincode.turbochess.domain.Piece;
import com.craftincode.turbochess.domain.Position;
import com.craftincode.turbochess.logic.RookMoveValidator;
import org.junit.Before;
import org.junit.Test;

import static com.craftincode.turbochess.domain.PieceColor.*;
import static com.craftincode.turbochess.domain.PieceType.ROOK;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class RookMoveValidatorTest {
    private static Piece whiteRook = new Piece(ROOK, WHITE);
    private static Piece blackRook = new Piece(ROOK, BLACK);
    private ChessBoard board;

    @Before
    public void initializeBoard(){
        board = ChessBoard.getEmptyBoard();
    }

    @Test
    public void isValid_moveForwardBy5WithNoPieceOnTheWay_returnsTrue(){
        board.setPiece(whiteRook, new Position("H1"));
        Move move = new Move(new Position("H1"), new Position("H6"));
        RookMoveValidator rookMoveValidator = new RookMoveValidator();

        assertTrue(rookMoveValidator.isValid(move, board));
    }

    @Test
    public void isValid_moveLeftBy3WithNoPieceOnTheWay_returnsTrue(){
        board.setPiece(whiteRook, new Position("H1"));
        Move move = new Move(new Position("H1"), new Position("E1"));
        RookMoveValidator rookMoveValidator = new RookMoveValidator();

        assertTrue(rookMoveValidator.isValid(move, board));
    }

    @Test
    public void isValid_moveRightBy2WithNoPieceOnTheWay_returnsTrue(){
        board.setPiece(blackRook, new Position("A8"));
        Move move = new Move(new Position("A8"), new Position("C8"));
        RookMoveValidator rookMoveValidator = new RookMoveValidator();

        assertTrue(rookMoveValidator.isValid(move, board));
    }

    @Test
    public void isValid_moveBackwardsBy5WithNoPieceOnTheWay_returnsTrue(){
        board.setPiece(blackRook, new Position("A8"));
        Move move = new Move(new Position("A8"), new Position("A3"));
        RookMoveValidator rookMoveValidator = new RookMoveValidator();

        assertTrue(rookMoveValidator.isValid(move, board));
    }

    @Test
    public void isValid_moveForwardBy2ButAnotherPieceISOnTheWay_returnsFalse() {
        board.setPiece(whiteRook, new Position("H1"));
        board.setPiece(blackRook, new Position("H2"));
        Move move = new Move(new Position("H1"), new Position("H3"));
        RookMoveValidator rookMoveValidator = new RookMoveValidator();

        assertFalse(rookMoveValidator.isValid(move, board));
    }

    @Test
    public void isValid_moveForwardBy2WithPieceOfAnotherColorOnFinalPosition_returnsTrue() {
        board.setPiece(whiteRook, new Position("D2"));
        board.setPiece(blackRook, new Position("D5"));
        Move move = new Move(new Position("D2"), new Position("D5"));
        RookMoveValidator rookMoveValidator = new RookMoveValidator();

        assertTrue(rookMoveValidator.isValid(move, board));
    }

    @Test
    public void isValid_moveLeftBy3WithPieceOfSAmeColorOnFinalPosition_returnsFalse() {
        board.setPiece(whiteRook, new Position("G3"));
        board.setPiece(whiteRook, new Position("D3"));
        Move move = new Move(new Position("G3"), new Position("D3"));
        RookMoveValidator rookMoveValidator = new RookMoveValidator();

        assertFalse(rookMoveValidator.isValid(move, board));
    }
}
