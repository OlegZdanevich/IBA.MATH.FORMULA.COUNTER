package com.iba.project.logic.parser.divide.nodes;

import com.iba.project.logic.parser.divide.abstraction.Node;

import java.util.ArrayList;
import java.util.List;

public class TextNode implements Node
{
    private List<Node> listOfChildNodes=new ArrayList<Node>();
    private StringBuilder data=new StringBuilder();


    public StringBuilder getData() {
        return data;
    }

    public void setData(StringBuilder data) {
        this.data = data;
    }

    @Override
    public List<Node> getListOfChildNodes() {
        return listOfChildNodes;
    }

    @Override
    public void setListOfChildNodes(List<Node> listOfChildNodes) {
        this.listOfChildNodes = listOfChildNodes;
    }

    @Override
    public void add(Node node) {
        listOfChildNodes.add(node);
    }

    @Override
    public void remove(Node node) {
        listOfChildNodes.remove(node);
    }

}
