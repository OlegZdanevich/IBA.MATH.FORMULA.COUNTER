package com.iba.project.data;

import java.util.ArrayList;
import java.util.List;

public class NodeImpl implements Node
{
    private List<Node> leafs=null;

    public NodeImpl()
    {
        this.leafs=new ArrayList<>();
    }

    public void addLeaf(Node leaf)
    {
        leafs.add(leaf);
    }


    public Node getLeaf(int i)
    {
        return leafs.get(i);
    }


    public int size()
    {
        return leafs.size();
    }

    @Override
    public StringBuilder count() {
        StringBuilder result=new StringBuilder("");

        for(Node leaf:leafs)
        {
            result.append(leaf.count());
        }

        return  result;
    }

}
