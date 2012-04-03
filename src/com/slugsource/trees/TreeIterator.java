package com.slugsource.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Nathan Fearnley
 */
public abstract class TreeIterator<T> implements Iterator<T>
{
    protected Queue<T> nodes;
    
    public TreeIterator()
    {
        nodes = new LinkedList<>();
    }
    
    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("This iterator does not support the remove operation.");
    }

    @Override
    public boolean hasNext()
    {
        return !nodes.isEmpty();
    }

    @Override
    public T next()
    {
        return nodes.poll();
    }
}
