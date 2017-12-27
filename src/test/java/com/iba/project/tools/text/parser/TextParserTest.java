package com.iba.project.tools.text.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextParserTest {

    private String testString="asdakdf. sadhahsdg (1+2)*3^5 \ndskhkfhbkjsd 1+72 dfdsf \n";


    @Test
    public void parse() {
        assertEquals(null,TextParser.parse(testString));
    }
}