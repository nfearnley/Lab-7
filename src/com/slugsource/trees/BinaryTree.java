package com.slugsource.trees;

import java.util.Iterator;

/**
 *
 * @author Nathan Fearnley
 */
public class BinaryTree<T> implements Iterable<T>
{
    private static final int IN_ORDER = 0;
    private static final int PRE_ORDER = 1;
    private static final int POST_ORDER = 2;
    private int iteratorType = IN_ORDER;
    private TreeNode<T> root;

    public BinaryTree()
    {
    }

    public BinaryTree(T rootItem)
    {
        root = new TreeNode<>(rootItem);
    }

    public BinaryTree(T rootItem, BinaryTree<T> leftTree, BinaryTree<T> rightTree) throws TreeException
    {
        this(rootItem);
        attachLeftSubtree(leftTree);
        attachRightSubtree(rightTree);
    }

    protected BinaryTree(TreeNode<T> rootNode)
    {
        root = rootNode;
    }

    protected TreeNode<T> getRootNode()
    {
        return root;
    }

    public void makeEmpty()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public T getRootItem() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException: Empty tree");
        }

        return root.getPayload();
    }

    public void setRootItem(T item)
    {
        if (isEmpty())
        {
            root = new TreeNode<>();
        }

        root.setPayload(item);
    }

    public void attachLeft(T item)
    {
        if (!isEmpty() && root.getLeftTree() == null)
        {
            root.setLeftTree(new TreeNode<>(item));
        }
    }

    public void attachRight(T item)
    {
        if (!isEmpty() && root.getRightTree() == null)
        {
            root.setRightTree(new TreeNode<>(item));
        }
    }

    public void attachLeftSubtree(BinaryTree<T> tree) throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException: Empty tree");
        }
        if (root.getLeftTree() != null)
        {
            throw new TreeException("TreeException: Cannot overwrite left subtree");
        }

        root.setLeftTree(tree.getRootNode());
        tree.makeEmpty();

    }

    public void attachRightSubtree(BinaryTree<T> tree) throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException: Empty tree");
        }
        if (root.getRightTree() != null)
        {
            throw new TreeException("TreeException: Cannot overwrite left subtree");
        }

        root.setRightTree(tree.getRootNode());
        tree.makeEmpty();
    }

    public BinaryTree<T> detachLeftSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException: Empty tree");
        }

        BinaryTree<T> tree = new BinaryTree<>(root.getLeftTree());
        root.setLeftTree(null);
        return tree;
    }

    public BinaryTree<T> detachRightSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException: Empty tree");
        }

        BinaryTree<T> tree = new BinaryTree<>(root.getRightTree());
        root.setRightTree(null);
        return tree;
    }

    public BinaryTree<T> getLeftSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException: Empty tree");
        }

        BinaryTree<T> tree = new BinaryTree<>(root.getLeftTree());
        return tree;
    }

    public BinaryTree<T> getRightSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException: Empty tree");
        }

        BinaryTree<T> tree = new BinaryTree<>(root.getRightTree());
        return tree;
    }

    @Override
    public Iterator<T> iterator()
    {
        Iterator<T> iter = null;
        switch(iteratorType)
        {
            case IN_ORDER:
                iter = new InOrderTreeIterator<>(this);
                break;
            case PRE_ORDER:
                iter = new PreOrderTreeIterator<>(this);
                break;
            case POST_ORDER:
                iter = new PostOrderTreeIterator<>(this);
                break;
        }
        return iter;
    }
    
    public void setInOrderIterator()
    {
        iteratorType = IN_ORDER;
    }
    public void setPreOrderIterator()
    {
        iteratorType = PRE_ORDER;
    }
    public void setPostOrderIterator()
    {
        iteratorType = POST_ORDER;
    }
}
