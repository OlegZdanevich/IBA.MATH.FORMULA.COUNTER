package com.iba.project.tools.formula.counter;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormulaCounterTest {

    @Test
    public void doParse() {
        assertEquals("15.0",String.valueOf(FormulaCounter.doParse("1 2 + 4 * 3 +")));
        assertEquals("4.0",String.valueOf(FormulaCounter.doParse("1 2 + 4 * 3 /")));
        assertEquals(String.valueOf(1.0/12.0),String.valueOf(FormulaCounter.doParse("1 12 /")));
        assertEquals(String.valueOf(Math.pow(1.0+2.0,4.0/3.0)),String.valueOf(FormulaCounter.doParse("1 2 + 4 3 / ^")));

    }
}