package com.craftincode.turbochess.logic;

import com.craftincode.turbochess.domain.Piece;

public class MoveValidatorFactory {

    public static MoveValidator getValidatorForPiece(Piece piece){
        switch (piece.getType()){
            case PAWN: return new PawnMoveValidator();
            case QUEEN: return new QueenMoveValidator();
            default:throw  new RuntimeException("no validtor found");
        }
    }
}
