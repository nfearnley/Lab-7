package com.slugsource.trees;

import java.util.Iterator;

/**
 *
 * @author Nathan Fearnley
 */
public abstract class TreeIterator<T> implements Iterator<T>
{

    protected BinaryTree<T> tree;

    public TreeIterator(BinaryTree<T> tree)
    {
        this.tree = tree;
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("This iterator does not support the remove operation.");
    }
}
