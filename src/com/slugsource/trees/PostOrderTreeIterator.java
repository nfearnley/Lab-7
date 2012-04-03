package com.slugsource.trees;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nathan Fearnley
 */
public class PostOrderTreeIterator<T> extends TreeIterator<T>
{

    public PostOrderTreeIterator(BinaryTree<T> tree)
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
            enqueue(tree.getRightSubtree());
            nodes.add(tree.getRootItem());
        } catch (Exception e)
        {
        }
    }
}
