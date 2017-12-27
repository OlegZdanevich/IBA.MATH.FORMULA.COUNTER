package com.iba.project.tools.text.parser;

import com.iba.project.data.Node;


public class TextParser
{
    public static Node parse(String data)
    {
        LineParser parser=new LineParser();

        parser.linkWith(new SentencesParser()).linkWith(new TabsParser());
        return parser.parse(new StringBuilder(data));
    }



}
