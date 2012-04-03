package com.slugsource.trees;

import java.util.LinkedList;

/**
 *
 * @author Nathan Fearnley
 */
public class PreOrderTreeIterator<T> extends TreeIterator<T>
{
    public PreOrderTreeIterator(BinaryTree<T> tree)
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
            nodes.add(tree.getRootItem());
            enqueue(tree.getLeftSubtree());
            enqueue(tree.getRightSubtree());
        } catch (Exception e)
        {
        }
    }
}
