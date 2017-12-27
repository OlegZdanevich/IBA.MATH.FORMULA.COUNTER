package com.iba.project.tools.text.parser;

import com.iba.project.data.Node;
import com.iba.project.data.NodeImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser
{
    protected Parser next;


    public Parser linkWith(Parser next)
    {
        this.next=next;

        return next;
    }


    public abstract Node parse(StringBuilder parserData);

    protected Node parseNext(StringBuilder parserData)
    {
        if(next==null)
        {
            return null;
        }

        return next.parse(parserData);
    }


    protected static NodeImpl addNode(Parser parser,StringBuilder parserData, String regexp)
    {
        NodeImpl node=new NodeImpl();

        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(parserData);

        while (matcher.find()) {
            int start = matcher.start();

            StringBuilder line = new StringBuilder(parserData.substring(0, start + 1));
            parserData.delete(0, start + 1);

            matcher = pattern.matcher(parserData);

            node.addLeaf(parser.parseNext(line));

        }

        return node;
    }
}
