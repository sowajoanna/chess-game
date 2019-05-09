package com.craftincode.turbochess.logic;

import com.craftincode.turbochess.domain.ChessBoard;
import com.craftincode.turbochess.domain.Move;
import com.craftincode.turbochess.domain.Piece;
import com.craftincode.turbochess.domain.PieceColor;

public class PawnMoveValidator implements MoveValidator {
    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {
        Piece pieceToMove = chessBoard.getPiece(move.getFromPosition());
        PieceColor pieceToMoveColor = pieceToMove.getColor();
        int verticalModifier = calculateVerticalModifier(pieceToMoveColor);

       if(!moveIsWithinLegalRadius(move,verticalModifier)){
           return false;
       }
       return true;
    }

    private boolean moveIsWithinLegalRadius(Move move, int verticalModifier){
        if (movedMoreThan2StepsVertically(move)) {
            return false;
        }
        if (movedMoreThan1StepHorizontally(move)) {
            return false;
        }
        if (noVerticalMovement(move)) {
            return false;
        }
        if (movedBackwords(move, verticalModifier)) {
            return false;
        }

        return true;
    }

    private int calculateVerticalModifier(PieceColor pieceColor) {
        return pieceColor.equals(PieceColor.BLACK) ? -1 : 1;
    }

    private boolean movedBackwords(Move move, int verticalModifier) {
        return move.verticalShift() * verticalModifier < 0;
    }

    private boolean noVerticalMovement(Move move) {
        return move.verticalShift() == 0;
    }

    private boolean movedMoreThan2StepsVertically(Move move) {
        return Math.abs(move.verticalShift()) > 2;
    }

    private boolean movedMoreThan1StepHorizontally(Move move) {
        return Math.abs(move.horizontalShift()) > 1;
    }


}
