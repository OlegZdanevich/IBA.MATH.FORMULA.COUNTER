package com.iba.project.entity.node.abstraction;

public interface NodeInterface <T extends NodeInterface> {
    void setNext(T next);
    void doAction();
}
