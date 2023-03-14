package com.vtv.algorithms.tree;

public class TreeUtils{
    public static <T> void printTreeToConsole(ITree<T> tree, String indent) {
        System.out.println(indent + tree.Root());
        indent += "|-  ";
        for (int i = 0; i < tree.numberSubTrees(); i++)
            printTreeToConsole(tree.getSubTree(i), indent);
    }
}
