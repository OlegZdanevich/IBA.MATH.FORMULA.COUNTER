package com.iba.project.tools.text.parser;

import com.iba.project.data.Formula;
import com.iba.project.data.Node;
import com.iba.project.data.NodeImpl;
import com.iba.project.data.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TabsParser extends Parser {


    @Override
    public Node parse(StringBuilder parserData) {
        NodeImpl node = new NodeImpl();


        while (parserData.indexOf(" ") != -1) {
            int start = parserData.indexOf(" ");

            StringBuilder line = new StringBuilder(parserData.substring(0, start + 1));
            parserData.delete(0, start + 1);

            addNode(line, node);

        }

        if (parserData.length() != 0) {
            addNode(parserData, node);
        }

        return node;
    }

    private void addNode(StringBuilder line, NodeImpl node) {
        Pattern patternFormula = Pattern.compile("[0-9(*+\\-/^)]");

        Matcher isTheFormula = patternFormula.matcher(line);

        if (isTheFormula.find()) {
            node.addLeaf(new Formula(line.toString()));
        } else {
            node.addLeaf(new Text(line.toString()));
        }
    }

}
