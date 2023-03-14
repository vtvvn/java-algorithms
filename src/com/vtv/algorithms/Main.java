package com.vtv.algorithms;

import com.vtv.algorithms.tree.GeneralTree;
import com.vtv.algorithms.tree.TreeUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GeneralTree<String> tree = new GeneralTree<>("10");
        GeneralTree<String> subtree1 = new GeneralTree<>("1");
        GeneralTree<String> subtree2 = new GeneralTree<>("2");
        GeneralTree<String> subtree3 = new GeneralTree<>("3");
        GeneralTree<String> subtree4 = new GeneralTree<>("4");
        GeneralTree<String> subtree5 = new GeneralTree<>("5");
        GeneralTree<String> subtree6 = new GeneralTree<>("6");
        GeneralTree<String> subtree7 = new GeneralTree<>("7");
        subtree2.addSubTree(subtree3);
        subtree2.addSubTree(subtree4);
        subtree3.addSubTree(subtree5);
        subtree3.addSubTree(subtree6);
        tree.addSubTree(subtree1);
        tree.addSubTree(subtree2);
        tree.addSubTree(subtree7);
        List<String> preoderList = tree.preorder();
        System.out.println("preoder:");
        printList(preoderList);
        List<String> inorderList = tree.inorder();
        System.out.println("inoder:");
        printList(inorderList);
        List<String> postorderList = tree.postorder();
        System.out.println("postoder:");
        printList(postorderList);
        List<String> breathFirstSearchList = tree.breathFirstSearch();
        System.out.println("breathFirstSearchList:");
        printList(breathFirstSearchList);
        System.out.println("Tree structure:");
        TreeUtils.printTreeToConsole(tree, "");
    }
    static <T> void printList(List<T> list){
        for(T elem: list){
            System.out.print(elem + ", ");
        }
        System.out.println();
    }
}
