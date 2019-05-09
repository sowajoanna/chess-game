package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.ChessBoard;
import com.craftincode.turbochess.domain.Move;
import com.craftincode.turbochess.domain.Piece;
import com.craftincode.turbochess.domain.Position;
import com.craftincode.turbochess.logic.MoveValidator;
import com.craftincode.turbochess.logic.QueenMoveValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static com.craftincode.turbochess.domain.PieceColor.BLACK;
import static com.craftincode.turbochess.domain.PieceColor.WHITE;
import static com.craftincode.turbochess.domain.PieceType.QUEEN;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
@Category(ValidatorTests.class)
public class QueenMoveValidatorParameterizedTest {
    private ChessBoard chessBoard;
    private MoveValidator moveValidator;
    private static Piece whiteQueen = new Piece(QUEEN, WHITE);
    private static Piece blackQueen = new Piece(QUEEN, BLACK);


    @Parameterized.Parameter(0)
    public String srcPos;
    @Parameterized.Parameter(1)
    public String opponentPos;
    @Parameterized.Parameter(2)
    public String dstPos;
    @Parameterized.Parameter(3)
    public Piece srcPiece;
    @Parameterized.Parameter(4)
    public Piece opponentPiece;
    @Parameterized.Parameter(5)
    public boolean expectedResult;
    @Parameterized.Parameter(6)
    public String testName;

    @Parameterized.Parameters(name = "{index}: {6}")
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"C1", "C2", "C7", whiteQueen, null, true,"move diagonally with no opponent"},
                {"C1", "C2", "C3", whiteQueen, blackQueen, false,"move vertically with opponent"},
                {"H2", "G2", "B2", whiteQueen, null, true,"move diagonally without opponent"}
        });
    }

    @Before
    public void initializeBoard() {
        chessBoard = ChessBoard.getEmptyBoard();
        moveValidator = new QueenMoveValidator();
    }

    @Test
    public void isValid_moveHorizontalBy6WhenPathIsClear_returnTrue() {
        chessBoard.setPiece(srcPiece, new Position(srcPos));
        chessBoard.setPiece(opponentPiece, new Position(opponentPos));
        Move moveHorizontal = new Move(new Position(srcPos), new Position(dstPos));
        assertEquals(moveValidator.isValid(moveHorizontal, chessBoard), expectedResult);
    }
}
