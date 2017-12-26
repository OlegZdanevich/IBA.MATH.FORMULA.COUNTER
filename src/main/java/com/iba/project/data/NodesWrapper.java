package com.iba.project.data;


import java.util.ArrayList;
import java.util.List;

public class NodesWrapper
{
    List<Node> data=null;

    public NodesWrapper()
    {
        data=new ArrayList<>();
    }

    public NodesWrapper(List<Node> data)
    {
        this.data=data;
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
