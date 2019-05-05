package com.craftincode.turbochess.logic;

import com.craftincode.turbochess.domain.ChessBoard;
import com.craftincode.turbochess.domain.Move;
import com.craftincode.turbochess.domain.Piece;

public class KnightMoveValidator implements MoveValidator {
    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {

        int verticalShift = Math.abs(move.verticalShift());
        int horizontalShift = Math.abs(move.horizontalShift());
        int sumShift = verticalShift + horizontalShift;


        if (isFriendlyPieceOnTheTargetPosition(move, chessBoard)) {
            return false;
        }

        if (verticalShift == 0 || horizontalShift == 0) {
            return false;
        }
        if (sumShift == 3) {
            return true;
        }
        return false;
    }

    private boolean isFriendlyPieceOnTheTargetPosition(Move move, ChessBoard chessBoard) {
        if (chessBoard.getPiece(move.getToPosition()) == null) {
            return false;
        }

        Piece myPiece = chessBoard.getPiece(move.getFromPosition());
        Piece otherPiece = chessBoard.getPiece(move.getToPosition());

        return (myPiece.getColor() == otherPiece.getColor());
    }
}
