package com.craftincode.turbochess.logic;

import com.craftincode.turbochess.domain.*;

public class RookMoveValidator implements MoveValidator {
    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {
        if (noMovement(move)) {
            return false;
        }
        if (movedDiagonally(move)) {
            return false;
        }
        if (anotherPieceInTheWay(move, chessBoard)) {
            return false;
        }
        if (toPositionContainsPieceOfSameColor(move, chessBoard)) {
            return false;
        }
        return true;
    }

    private boolean toPositionContainsPieceOfSameColor(Move move, ChessBoard chessBoard) {
        Piece pieceToMove = chessBoard.getPiece(move.getFromPosition());
        Piece pieceOnToPosition = chessBoard.getPiece(move.getToPosition());
        if (pieceOnToPosition == null) {
            return false;
        }
        return pieceToMove.getColor().equals(pieceOnToPosition.getColor());
    }

    private boolean anotherPieceInTheWay(Move move, ChessBoard board) {
        Position start = move.getFromPosition();
        Position end = move.getToPosition();

        if (move.horizontalShift() > 0) {
            return pieceInTheWayHorizontally(end, start, board);
        }
        if (move.horizontalShift() < 0) {
            return pieceInTheWayHorizontally(start, end, board);
        }
        if (move.verticalShift() > 0) {
            return pieceInTheWayVertically(end, start, board);
        }
        if (move.verticalShift() < 0) {
            return pieceInTheWayVertically(start, end, board);
        }
        return false;
    }

    private boolean pieceInTheWayVertically(Position lower, Position higher, ChessBoard board) {
        for (int i = lower.getRow() + 1; i < higher.getRow(); i++) {
            if (board.getPiece(new Position(i, lower.getColumn())) != null) {
                return true;
            }
        }
        return false;
    }

    private boolean pieceInTheWayHorizontally(Position lower, Position higher, ChessBoard board) {
        for (int i = lower.getColumn() + 1; i < higher.getColumn(); i++) {
            if (board.getPiece(new Position(lower.getRow(), i)) != null) {
                return true;
            }
        }
        return false;
    }

    private boolean movedDiagonally(Move move) {
        return movedVertically(move) && movedHotizontally(move);
    }

    private boolean movedHotizontally(Move move) {
        return Math.abs(move.horizontalShift()) > 0;
    }

    private boolean movedVertically(Move move) {
        return Math.abs(move.verticalShift()) > 0;
    }

    private boolean noMovement(Move move) {
        return move.verticalShift() == 0 && move.horizontalShift() == 0;
    }
}
