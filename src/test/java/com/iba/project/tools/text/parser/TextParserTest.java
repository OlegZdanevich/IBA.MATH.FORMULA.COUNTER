package com.iba.project.tools.text.parser;

import com.iba.project.data.NodesWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextParserTest {

    private String testString="asdakdf. sadhahsdg (1+2)*3^5 dskhkfhbkjsd 1+72 dfdsf";


    @Test
    public void parse() {
        assertEquals(new NodesWrapper(),TextParser.parse(testString));
    }
}