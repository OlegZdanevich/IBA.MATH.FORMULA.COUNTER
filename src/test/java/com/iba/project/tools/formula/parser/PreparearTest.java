package com.iba.project.tools.formula.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PreparearTest {

    StringBuilder formula=null;

    @Before
    public void setUp()
    {
        formula=new StringBuilder("(1+2)^(4/3)");
    }

    @After
    public void tearDown() {
        formula=null;
    }

    @Test
    public void prepare() {
        Preparear.prepare(formula);
        assertEquals("(1+ 2)^ (4/ 3)",formula.toString());
    }
}