package com.craftincode.turbochess.logic;

import com.craftincode.turbochess.domain.ChessBoard;
import com.craftincode.turbochess.domain.Move;

public interface MoveValidator {
    boolean isValid(Move move, ChessBoard chessBoard);
}
