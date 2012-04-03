package com.slugsource.trees;

import java.util.LinkedList;

/**
 *
 * @author Nathan Fearnley
 */
public class InOrderTreeIterator<T> extends TreeIterator<T>
{

    public InOrderTreeIterator(BinaryTree<T> tree)
    {
        super();
        enqueue(tree);
    }

    private void enqueue(BinaryTree<T> tree)
    {
        if (tree == null)
        {
            return;
        }
        try
        {
            enqueue(tree.getLeftSubtree());
            nodes.add(tree.getRootItem());
            enqueue(tree.getRightSubtree());
        } catch (Exception e)
        {
        }
    }
}
