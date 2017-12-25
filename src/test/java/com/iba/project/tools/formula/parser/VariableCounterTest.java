package com.iba.project.tools.formula.parser;

import com.iba.project.data.Formula;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VariableCounterTest {

    VariableCounter variableCounter=null;

    Formula formula=null;

    @Before
    public void setUp() {
        this.variableCounter=VariableCounter.getInstance();

        variableCounter.setI(7);
        variableCounter.setJ(9);

        this.formula=new Formula("(71-(2*i--*(3*(2-1/2*2)-2)-10/2))*++i");
    }

    @After
    public void tearDown()
    {
        variableCounter=null;
        formula=null;
    }

    @Test
    public void change()
    {
        variableCounter.replace(formula);
        assertEquals("(71-(2*7*(3*(2-1/2*2)-2)-10/2))*7",formula.getFormula().toString());
    }


}