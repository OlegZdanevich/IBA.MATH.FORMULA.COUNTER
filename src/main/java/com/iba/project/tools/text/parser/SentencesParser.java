package com.iba.project.tools.text.parser;

import com.iba.project.data.Node;
import com.iba.project.data.NodeImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencesParser extends Parser {

    @Override
    public Node parse(StringBuilder parserData) {
        NodeImpl node = Parser.addNode(this,parserData,"[\\?\\.!]");

        if (parserData.length() != 0) {
            node.addLeaf(parseNext(parserData));
        }


        return node;
    }

}
