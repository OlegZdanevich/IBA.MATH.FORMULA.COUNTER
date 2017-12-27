package com.iba.project.tools.formula.counter;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormulaCounterTest {

    @Test
    public void doParse() {
        assertEquals(15.0,FormulaCounter.doParse(new StringBuilder("1 2 + 4 * 3 +")),.001);
        assertEquals(4.0,FormulaCounter.doParse(new StringBuilder("1 2 + 4 * 3 /")),.001);
        assertEquals(1.0/12.0,FormulaCounter.doParse(new StringBuilder("1 12 /")),.001);
        assertEquals(Math.pow(1.0+2.0,4.0/3.0),FormulaCounter.doParse(new StringBuilder("1 2 + 4 3 / ^")),.001);

    }
}