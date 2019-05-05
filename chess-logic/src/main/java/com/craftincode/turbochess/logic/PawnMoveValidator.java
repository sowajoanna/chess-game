package com.craftincode.turbochess.logic;

import com.craftincode.turbochess.domain.*;

public class PawnMoveValidator implements MoveValidator {
    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {

        int horizontalShift = move.horizontalShift();
        int verticalModifier = chessBoard.getPiece(move.getFromPosition()).getColor() == PieceColor.BLACK ? -1 : 1;
        int verticalShift = move.verticalShift() * verticalModifier;
        int rowPosition = move.getFromPosition().getRow();

        if (verticalShift == 1 && !isOtherPieceInTheWay(move, chessBoard)) {
            return true;
        } else if (verticalShift == 2 && !isOtherPieceInTheWay(move, chessBoard)) {
            if (((chessBoard.getPiece(move.getFromPosition()).getColor() == PieceColor.BLACK) && rowPosition == 1) ||
                    ((chessBoard.getPiece(move.getFromPosition()).getColor() == PieceColor.WHITE) && rowPosition == 6)) {
                return true;
            }
        } else if (verticalShift == 1 && (horizontalShift == 1 || horizontalShift == -1)
                && isOpponentPieceInTheWay(move, chessBoard)) {
            return true;
        }

        if (chessBoard.getPiece(move.getToPosition()) != null) {
            return false;
        }

        return false;
    }

    private boolean isOtherPieceInTheWay(Move move, ChessBoard chessBoard) {
        return (chessBoard.getPiece(move.getToPosition()) != null);
    }

    private boolean isOpponentPieceInTheWay(Move move, ChessBoard chessBoard) {
        Piece otherPiece = chessBoard.getPiece(move.getToPosition());
        Piece myPiece = chessBoard.getPiece(move.getFromPosition());

        return (myPiece.getColor() != otherPiece.getColor());
    }
}
