package com.iba.project.logic.parser.divide.abstraction;

import java.util.List;

public interface Node {

    List<Node> getListOfChildNodes();


    void setListOfChildNodes(List<Node> childNodes);

    void add(Node node);
    void remove(Node node);
}
