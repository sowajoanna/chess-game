package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void constructor_givenA2_returnsPositionRow6Col1(){
        Position p = new Position("A2");
        assertEquals(6, p.getRow());
        assertEquals(0, p.getColumn());
    }

}
