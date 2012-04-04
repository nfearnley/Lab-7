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
    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("This iterator does not support the remove operation.");
    }

}
