package com.slugsource.trees;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Nathan Fearnley
 */
public class PreOrderTreeIterator<T> extends TreeIterator<T>
{

    private static final Integer ENTER_FROM_PARENT = 1;
    private static final Integer RETURN_FROM_LEFT = 2;
    private static final Integer RETURN_FROM_RIGHT = 3;
    private Deque<BinaryTree<T>> parents = new LinkedList<>();
    private Deque<Integer> states = new LinkedList<>();
    private BinaryTree<T> currNode;
    private Integer state;
    private BinaryTree<T> resultNode = null;

    public PreOrderTreeIterator(BinaryTree<T> tree)
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
        return resultNode != null;
    }

    private void getNext()
    {
        while ((resultNode == null) && (currNode != null))
        {
            if (state == ENTER_FROM_PARENT)
            {
                resultNode = currNode;
            }

            if (currNode.getLeftSubtree().isEmpty() && state == ENTER_FROM_PARENT)
            {
                state = RETURN_FROM_LEFT;
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
        T result = resultNode.getRootItem();
        resultNode = null;
        return result;
    }
}
