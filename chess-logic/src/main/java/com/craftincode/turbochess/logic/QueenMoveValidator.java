package com.craftincode.turbochess.logic;

import com.craftincode.turbochess.domain.ChessBoard;
import com.craftincode.turbochess.domain.Move;
import com.craftincode.turbochess.domain.Piece;
import com.craftincode.turbochess.domain.Position;

public class QueenMoveValidator implements MoveValidator {
    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {
        //Piece queen = chessBoard.getPiece(move.getFromPosition());
        int horizontalDistance = Math.abs(move.horizontalShift());
        int verticalDistance = Math.abs(move.verticalShift());


        if (verticalDistance != horizontalDistance) {
            if (verticalDistance != 0 && horizontalDistance != 0) {
                return false;
            }
        }
        if (!isPathClear(move, chessBoard)) {
            return false;
        }
        return true;
    }


    public boolean isPathClear(Move move, ChessBoard chessBoard) {
        Position positionTemp = new Position("A1");
        if (move.horizontalShift() > 0) {
            if (move.verticalShift() > 0) {
                for (int i = move.getFromPosition().getColumn()+1; i < move.getToPosition().getColumn(); i++) {
                    positionTemp.setColumn(i);
                    positionTemp.setRow(i);
                    if (chessBoard.getPiece(positionTemp)!=null) {
                        return false;
                    }

                }
            }
            if (move.verticalShift() < 0) {
                int j = move.getFromPosition().getRow();
                for (int i = move.getFromPosition().getColumn()+1; i < move.getToPosition().getColumn(); i++) {
                    j--;
                    positionTemp.setColumn(i);
                    positionTemp.setRow(j);
                    if (chessBoard.getPiece(positionTemp)!=null) {
                        return false;
                    }
                }
            }
            if (move.verticalShift() == 0) {
                for (int i = move.getFromPosition().getColumn()+1; i < move.getToPosition().getColumn(); i++) {
                    positionTemp.setColumn(i);
                    positionTemp.setRow(move.getFromPosition().getRow());
                    if (chessBoard.getPiece(positionTemp)!=null) {
                        return false;
                    }

                }
            }
        }
        if (move.horizontalShift() < 0) {
            if (move.verticalShift() > 0) {
                int j = move.getFromPosition().getRow();
                for (int i = move.getFromPosition().getColumn()-1; i > move.getToPosition().getColumn(); i--) {
                    j++;
                    positionTemp.setColumn(i);
                    positionTemp.setRow(j);
                    if (chessBoard.getPiece(positionTemp)!=null) {
                        return false;
                    }

                }
            }
            if (move.verticalShift() < 0) {
                for (int i = move.getFromPosition().getColumn()-1; i > move.getToPosition().getColumn(); i--) {
                    positionTemp.setColumn(i);
                    positionTemp.setRow(i);
                    if (chessBoard.getPiece(positionTemp)!=null) {
                        return false;
                    }

                }
            }
            if (move.verticalShift() == 0) {
                for (int i = move.getFromPosition().getColumn()-1; i > move.getToPosition().getColumn(); i--) {
                    positionTemp.setColumn(i);
                    positionTemp.setRow(move.getFromPosition().getRow());
                    if (chessBoard.getPiece(positionTemp)!=null) {
                        return false;
                    }
                }

            }

        }
        if (move.horizontalShift() == 0) {

            if (move.verticalShift() > 0) {
                for (int j = move.getFromPosition().getRow()+1; j < move.getToPosition().getRow(); j++) {
                    positionTemp.setColumn(move.getFromPosition().getColumn());
                    positionTemp.setRow(j);
                    if (chessBoard.getPiece(positionTemp)!=null) {
                        return false;
                    }
                }
            }
            if (move.verticalShift() < 0) {
                for (int j = move.getFromPosition().getRow()-1; j > move.getToPosition().getRow(); j--) {
                    positionTemp.setColumn(move.getFromPosition().getColumn());
                    positionTemp.setRow(j);
                    if (chessBoard.getPiece(positionTemp)!=null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}


