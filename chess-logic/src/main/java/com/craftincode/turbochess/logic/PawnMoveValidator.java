package com.craftincode.turbochess.logic;

import com.craftincode.turbochess.domain.ChessBoard;
import com.craftincode.turbochess.domain.Move;
import com.craftincode.turbochess.domain.PieceColor;
import com.craftincode.turbochess.domain.Position;

public class PawnMoveValidator implements MoveValidator {
    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {
        Position fromPosition = move.getFromPosition();
        Position toPosition = move.getToPosition();
        boolean toPositionIsEmpty = chessBoard.getPiece(toPosition) == null;
        PieceColor color = chessBoard.getPiece(fromPosition).getColor();
        int verticalModifier = color.equals(PieceColor.BLACK) ? -1 : 1;
            if (toPositionIsEmpty) {
                if (move.verticalShift() == (verticalModifier * 2) && fromPosition.getRow() == 1) {
                    return true;
                }
                return move.verticalShift() == (verticalModifier * 1) && move.horizontalShift() == 0;
            } else if (!color.equals(chessBoard.getPiece(toPosition).getColor())) {
                return move.verticalShift() == (verticalModifier * 1) && (move.horizontalShift() == 1 || move.horizontalShift() == -1);
            }
            return false;
        }
    }
