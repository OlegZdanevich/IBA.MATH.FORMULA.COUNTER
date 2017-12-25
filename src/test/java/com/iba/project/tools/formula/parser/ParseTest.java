package com.iba.project.tools.formula.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParseTest {
    @Test
    public void parseTest()
    {
        assertEquals("1 2+ 4* 3+",Parser.parseExpression(new StringBuilder("(1+ 2)* 4+ 3")));
        assertEquals("1 2+ 4* 3/",Parser.parseExpression(new StringBuilder("(1+ 2)* 4/ 3")));
        assertEquals("1 12/",Parser.parseExpression(new StringBuilder("1/ 12")));
        assertEquals("1 2+ 4 3/^",Parser.parseExpression(new StringBuilder("(1+ 2)^ (4/ 3)")));
    }
}