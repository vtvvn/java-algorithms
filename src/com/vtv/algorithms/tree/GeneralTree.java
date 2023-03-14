package com.vtv.algorithms.tree;

import java.util.*;

public class GeneralTree<T> implements ITree<T>{
    private T root;
    private LinkedList<ITree<T>> childNodes;

    public GeneralTree(T root){
        this.root = root;
        childNodes = new LinkedList<>();
    }
    @Override
    public T Root() {
        return root;
    }

    @Override
    public boolean isLeaf() {
        return childNodes.isEmpty();
    }

    @Override
    public int numberSubTrees() {
        return childNodes.size();
    }

    @Override
    public ITree<T> getSubTree(int i) {
        return childNodes.get(i);
    }

    @Override
    public LinkedList<ITree<T>> getChildNodes() {
        return childNodes;
    }
    @Override
    public void addSubTree(ITree<T> subtree) {
        childNodes.add(subtree);
    }


    @Override
    public List<T> preorder() {
        return _preorder(new LinkedList<>());
    }

    private List<T> _preorder(List<T> result){
        result.add(root);
        if (!isLeaf()){
            for (ITree<T> subtree: childNodes) {
                ((GeneralTree)subtree)._preorder(result);
            }
        }
        return result;
    }

    @Override
    public List<T> inorder() {
        return _inorder(new LinkedList<>());
    }

    private List<T> _inorder(List<T> result){
        if (isLeaf()) {
            result.add(root);
        }
        else{
            ((GeneralTree)childNodes.get(0))._inorder(result);
            result.add(root);
            for (int i=1; i<numberSubTrees(); i++) {
                ((GeneralTree)childNodes.get(i))._inorder(result);
            }
        }
        return result;
    }

    @Override
    public List<T> postorder() {
        return _postorder(new LinkedList<>());
    }

    private List<T> _postorder(List<T> result){
        for (int i=0; i<numberSubTrees(); i++) {
            ((GeneralTree)childNodes.get(i))._postorder(result);
        }
        result.add(root);
        return result;
    }

    @Override
    public List<T> breathFirstSearch() {
        Queue<ITree<T>> queue = new ArrayDeque<>();
        queue.add(this);

        ITree<T> currentNode;
        Set<ITree<T>> alreadyVisited = new HashSet<>();
        List<T> alreadyVisitedNode = new ArrayList<>();
        while (!queue.isEmpty()) {
            currentNode = queue.remove();

            alreadyVisited.add(currentNode);
            alreadyVisitedNode.add(currentNode.Root());

            queue.addAll(currentNode.getChildNodes());
            queue.removeAll(alreadyVisited);
        }
        return alreadyVisitedNode;
    }

    @Override
    public int Height() {
        if(isLeaf())
            return 0;
        int max = 0;
        for (int i = 0; i < childNodes.size(); i++)
        {
            int h = childNodes.get(i).Height();
            if(max < h)
                max = h;
        }
        return max+1;
    }
}
