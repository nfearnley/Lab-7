package com.slugsource.trees;

/**
 *
 * @author Nathan Fearnley
 */
public class TreeNode<T>
{

    private TreeNode<T> leftTree;
    private TreeNode<T> rightTree;
    private T payload;

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

    public T getPayload()
    {
        return payload;
    }

    public void setPayload(T payload)
    {
        this.payload = payload;
    }
}
