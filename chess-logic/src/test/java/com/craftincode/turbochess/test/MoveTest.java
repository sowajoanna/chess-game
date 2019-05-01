package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.Move;
import com.craftincode.turbochess.domain.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveTest {

    @Test
    public void verticalShift_givenMove1Forward_returns1(){
        Move move = new Move(new Position("A2"), new Position("A3"));
        int verticalShift = move.verticalShift();
        assertEquals("verticalShift for A2 -> A3 should return 1", 1,verticalShift);
    }

    @Test
    public void horizontalShift_givenMove1Forward_returns0(){
        Move move = new Move(new Position("A2"), new Position("A3"));
        int horizontalShift = move.horizontalShift();
        assertEquals("horizontalShift for A2 -> A3 should return 0", 0,horizontalShift);
    }
}
