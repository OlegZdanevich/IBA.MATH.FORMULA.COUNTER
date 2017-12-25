package com.iba.project.data;

import java.util.ArrayList;

public class NodesWrapper
{
    ArrayList<Node> data=null;

    public NodesWrapper()
    {
        data=new ArrayList<>();
    }

    public void append(Node node)
    {
        data.add(node);
    }

    public String calculate()
    {
        StringBuilder result=new StringBuilder("");
        for(Node node:data)
        {
            result.append(node.count());
        }

        return result.toString();
    }
}
