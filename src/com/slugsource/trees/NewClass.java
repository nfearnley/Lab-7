package com.slugsource.trees;

/**
 *
 * @author Nathan Fearnley
 */
public class BinaryTree<T> extends BinaryTreeBasis<T>
{

    public BinaryTree()
    {
    }

    public BinaryTree(T rootItem)
    {
        super(rootItem);
    }

    public BinaryTree(T rootItem, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        root = new TreeNode<T>(rootItem, null, null);
        attachLeftSubtree(leftTree);
        attachRightSubtree(rightTree);
    }

    public void setRootItem(T newItem)
    {
        if (root != null)
        {
            root.item = newItem;
        } else
        {
            root = new TreeNode<T>(newItem, null, null);
        }
    }

    public void attachLeft(T newItem)
    {
        if (!isEmpty() && root.leftChild == null)
        {
            root.leftChild = new TreeNode<T>(newItem, null, null);
        }
    }

    public void attachRight(T newItem)
    {
        if (!isEmpty() && root.rightChild == null)
        {
            root.rightChild = new TreeNode<T>(newItem, null, null);
        }
    }

    public void attachLeftSubtree(BinaryTree<T> leftTree) throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException: Empty tree");
        } else if (root.leftChild != null)
        {
            throw new TreeException(" TreeException:  "
                    + " Cannot overwrite left subtree");
        } else
        {
            root.leftChild = leftTree.root;
            leftTree.makeEmpty();
        }
    }

    public void attachRightSubtree(BinaryTree<T> rightTree) throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException(" TreeException:   Empty tree");
        } else if (root.rightChild != null)
        {
            throw new TreeException(" TreeException:  "
                    + " Cannot overwrite right subtree");
        } else
        {
            root.rightChild = rightTree.root;
            rightTree.makeEmpty();
        }
    }

    protected BinaryTree(TreeNode<T> rootNode)
    {
        root = rootNode;
    }

    public BinaryTree<T> detachLeftSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException(" TreeException:   Empty tree");
        } else
        {
            BinaryTree<T> leftTree;
            leftTree = new BinaryTree<T>(root.leftChild);
            root.leftChild = null;
            return leftTree;
        }
    }

    public BinaryTree<T> detachRightSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException(" TreeException:   Empty tree");
        } else
        {
            BinaryTree<T> rightTree;
            rightTree = new BinaryTree<T>(root.rightChild);
            root.rightChild = null;
            return rightTree;
        }
    }
}
