package com.craftincode.turbochess.test;

import com.craftincode.turbochess.domain.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void constructor_givenA2_returnsPositionRow6Col1(){
        Position p = new Position("A2");
        assertEquals(p.getRow(),6);
        assertEquals(p.getColumn(), 0);
    }

    @Test
    public void constructor_givenD8_returnsPositionRow0Col3(){
        Position p = new Position("D8");
        assertEquals(p.getRow(),0);
        assertEquals(p.getColumn(), 3);
    }

    @Test
    public void constructor_givenA1_returnsPositionRow7Col0(){
        Position p = new Position("A1");
        assertEquals(p.getRow(),7);
        assertEquals(p.getColumn(), 0);
    }

}
