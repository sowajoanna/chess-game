package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.*;
import com.craftincode.turbochess.logic.MoveValidator;
import com.craftincode.turbochess.logic.QueenMoveValidator;
import org.junit.Before;
import org.junit.Test;
import static com.craftincode.turbochess.domain.PieceColor.BLACK;
import static com.craftincode.turbochess.domain.PieceColor.WHITE;
import static com.craftincode.turbochess.domain.PieceType.QUEEN;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class QueenMoveValidatorTest {
    private static Piece whiteQueen = new Piece(QUEEN,WHITE);
    private static Piece blackQueen = new Piece(QUEEN, BLACK);
    private ChessBoard chessBoard;

    @Before
    public void initializeBoard(){
        chessBoard = ChessBoard.getEmptyBoard();
    }

    @Test
    public void isValid_moveVerticalBy6WhenPathIsClear_returnTrue(){
        chessBoard.setPiece(whiteQueen,new Position(("C1")));
        chessBoard.setPiece(null,new Position("C2"));
        Move moveVertical =  new Move(new Position("c1"), new Position("c7"));
        MoveValidator moveValidator = new QueenMoveValidator();
        assertTrue(moveValidator.isValid(moveVertical,chessBoard));
    }
    @Test
    public void isValid_moveVerticalBy2WhenAnotherPieceOnPath_returnFalse(){
        chessBoard.setPiece(whiteQueen,new Position("C1"));
        chessBoard.setPiece(blackQueen, new Position("C2"));
        Move moveVertical = new Move(new Position("C1"),new Position("C3"));
        MoveValidator moveValidator = new QueenMoveValidator();
        assertFalse(moveValidator.isValid(moveVertical,chessBoard));
    }
    @Test
    public void isValid_moveHorizontalBy6WhenPathIsClear_returnTrue(){
        chessBoard.setPiece(whiteQueen,new Position("H2"));
        chessBoard.setPiece(null,new Position("G2"));
        Move moveHorizontal = new Move(new Position("H2"),new Position("B2"));
        MoveValidator moveValidator = new QueenMoveValidator();
        assertTrue(moveValidator.isValid(moveHorizontal,chessBoard));
    }
    @Test
    public void isValid_moveHorizontalBy6WhenAnotherPieceOnPath_returnFalse(){
        chessBoard.setPiece(blackQueen,new Position("A1"));
        chessBoard.setPiece(whiteQueen,new Position("b1"));
        Move moveHorizontal = new Move(new Position("A1"), new Position("g1"));
        MoveValidator moveValidator = new QueenMoveValidator();
        assertFalse(moveValidator.isValid(moveHorizontal,chessBoard));
    }
    @Test
    public void isValid_moveSkewBy4WhenPathIsClear_returnTrue(){
        chessBoard.setPiece(whiteQueen,new Position("A1"));
        chessBoard.setPiece(null, new Position("B2"));
        Move moveSkew = new Move(new Position("A1"), new Position("E5"));
        MoveValidator moveValidator = new QueenMoveValidator();
        assertTrue(moveValidator.isValid(moveSkew,chessBoard));
    }
    @Test
    public void isValid_moveSkewBy4WhenAnotherPieceOnPath_returnFalse(){
        chessBoard.setPiece(whiteQueen,new Position("E5"));
        chessBoard.setPiece(blackQueen,new Position("B2"));
        Move moveSkew = new Move(new Position("E5"), new Position("A1"));
        MoveValidator moveValidator = new QueenMoveValidator();
        assertFalse(moveValidator.isValid(moveSkew,chessBoard));
    }
}
