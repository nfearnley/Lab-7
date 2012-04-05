package com.slugsource.trees;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Nathan Fearnley
 */
public class InOrderTreeIterator<T> extends TreeIterator<T>
{

    private static final Integer ENTER_FROM_PARENT = 1;
    private static final Integer RETURN_FROM_LEFT = 2;
    private static final Integer RETURN_FROM_RIGHT = 3;
    Deque<BinaryTree<T>> parents = new LinkedList<>();
    Deque<Integer> states = new LinkedList<>();
    BinaryTree<T> currNode;
    Integer state;
    private boolean haveResult = false;
    private T result = null;

    public InOrderTreeIterator(BinaryTree<T> tree)
    {
        currNode = tree;
        state = ENTER_FROM_PARENT;
        if (currNode.isEmpty())
        {
            currNode = null;
        }
        getNext();
    }

    @Override
    public boolean hasNext()
    {
        getNext();
        return haveResult;
    }

    private void getNext()
    {
        while (!haveResult && (currNode != null))
        {
            if (currNode.getLeftSubtree().isEmpty() && state == ENTER_FROM_PARENT)
            {
                state = RETURN_FROM_LEFT;
            }
            if (state == RETURN_FROM_LEFT)
            {
                result = currNode.getRootItem();
                haveResult = true;
            }
            if (currNode.getRightSubtree().isEmpty() && state == RETURN_FROM_LEFT)
            {
                state = RETURN_FROM_RIGHT;
            }

            if (state == ENTER_FROM_PARENT)
            {
                parents.push(currNode);
                states.push(RETURN_FROM_LEFT);
                currNode = currNode.getLeftSubtree();
                state = ENTER_FROM_PARENT;
            } else if (state == RETURN_FROM_LEFT)
            {
                parents.push(currNode);
                states.push(RETURN_FROM_RIGHT);
                currNode = currNode.getRightSubtree();
                state = ENTER_FROM_PARENT;
            } else if (state == RETURN_FROM_RIGHT)
            {
                currNode = parents.pollFirst();
                state = states.pollFirst();
            }
        }
    }

    @Override
    public T next()
    {
        getNext();
        haveResult = false;
        return result;
    }
}
