package com.iba.project.tools.text.parser;

import com.iba.project.data.Node;
import com.iba.project.data.NodeImpl;

public class LineParser extends Parser {

    private NodeImpl node = new NodeImpl();

    @Override
    public Node parse(StringBuilder parserData) {

        node=Parser.addNode(this,parserData,"\n");

        return node;
    }

}
