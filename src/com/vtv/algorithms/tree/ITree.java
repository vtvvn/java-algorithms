package com.vtv.algorithms.tree;

import java.util.LinkedList;
import java.util.List;

public interface ITree<T> {
    T Root();
    boolean isLeaf();
    int numberSubTrees();
    ITree<T> getSubTree(int i);
    LinkedList<ITree<T>> getChildNodes();
    void addSubTree(ITree<T> subtree);
    List<T> preorder();
    List<T> inorder();
    List<T> postorder();
    List<T> breathFirstSearch();
    int Height();
}
