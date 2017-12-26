package com.iba.project.tools.text.parser;

import com.iba.project.data.Formula;
import com.iba.project.data.Node;
import com.iba.project.data.NodesWrapper;
import com.iba.project.data.Text;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser
{
    public static NodesWrapper parse(String data)
    {
        NodesWrapper nodes=new NodesWrapper();

        StringBuilder text=new StringBuilder(data);
        Pattern pattern=Pattern.compile("[0-9(*+\\-/^)]");

        Matcher matcher=pattern.matcher(text);

        while (matcher.find())
        {
            int start=matcher.start();

            int end=matcher.end();

            if(start!=0) {
                Text nodeText=new Text(text.substring(0,start));
                Formula nodeFormula=new Formula(text.substring(start,end));
                text.delete(0,end);

                matcher=pattern.matcher(text);

                nodes.append(nodeText);
                nodes.append(nodeFormula);
            }
            else {
                Formula nodeFormula=new Formula(text.substring(start,end));
                text.delete(start,end);

                matcher=pattern.matcher(text);

                nodes.append(nodeFormula);
            }

        }
        System.out.println("1");

        return nodes;


    }
}
