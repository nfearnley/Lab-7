package com.slugsource.trees;

/**
 *
 * @author Nathan Fearnley
 */
public class TreeNode<T>
{

    private T payload;
    private TreeNode<T> leftTree;
    private TreeNode<T> rightTree;

    public TreeNode()
    {
        this(null, null, null);
    }
    
    public TreeNode(T payload)
    {
        this(payload, null, null);
    }

    public TreeNode(T payload, TreeNode<T> leftTree, TreeNode<T> rightTree)
    {
        this.payload = payload;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public T getPayload()
    {
        return payload;
    }

    public void setPayload(T payload)
    {
        this.payload = payload;
    }

    public TreeNode<T> getLeftTree()
    {
        return leftTree;
    }

    public void setLeftTree(TreeNode<T> leftTree)
    {
        this.leftTree = leftTree;
    }

    public TreeNode<T> getRightTree()
    {
        return rightTree;
    }

    public void setRightTree(TreeNode<T> rightTree)
    {
        this.rightTree = rightTree;
    }
}
