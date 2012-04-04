package com.slugsource.trees;

/**
 *
 * @author Nathan Fearnley
 */
public class TreeNode<T>
{

    private T payload;
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    public TreeNode()
    {
        this(null, null, null);
    }
    
    public TreeNode(T payload)
    {
        this(payload, null, null);
    }

    public TreeNode(T payload, TreeNode<T> leftNode, TreeNode<T> rightNode)
    {
        this.payload = payload;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public T getPayload()
    {
        return payload;
    }

    public void setPayload(T payload)
    {
        this.payload = payload;
    }

    public TreeNode<T> getLeftNode()
    {
        return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode)
    {
        this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode()
    {
        return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode)
    {
        this.rightNode = rightNode;
    }
}
