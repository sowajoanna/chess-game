package com.craftincode.turbochess.test;

import com.craftincode.turbochess.commons.InvalidPositionString;
import com.craftincode.turbochess.domain.Position;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionTest {
//    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructor_givenA2_returnsPositionRow6Col1() {
        Position p = new Position("A2");
        assertEquals(p.getRow(), 6);
        assertEquals(p.getColumn(), 0);
    }


    @Test
    public void constructor_givenZ3_throwsInvalidPositionString() {
        boolean exceptionThrown = false;
        try {
            new Position("Z3");
        } catch (InvalidPositionString e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Ignore
    @Test
    public void constructor_givenZ3_throwsInvalidPositionString2() {
        expectedException.expect(InvalidPositionString.class);
        new Position("Z3");
    }

    @Test(expected = InvalidPositionString.class)
    public void constructor_givenZ3_throwsInvalidPositionString3() {
        new Position("Z3");
    }

}
