package test.java;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFirstTest {

    @Test
    public void canAddTwoPlusTwo() {
        int answer = 2+2;
        assertEquals("2+2=4", 4, answer);
    }

    // Exercise: Write Test to subtract 2 from 2

}
