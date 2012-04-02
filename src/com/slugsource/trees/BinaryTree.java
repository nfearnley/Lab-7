package com.slugsource.trees;

/**
 *
 * @author Nathan Fearnley
 */
public interface BinaryTree<T>
{
    public void makeEmpty() throws TreeException;
    public boolean isEmpty() throws TreeException;
    public T getRootItem() throws TreeException;
    public void setRootItem(T item) throws TreeException;
    public void attachLeft(T item) throws TreeException;
    public void attachRight(T item) throws TreeException;
    public void attachLeftSubtree(BinaryTree<T> tree) throws TreeException;
    public void attachRightSubtree(BinaryTree<T> tree) throws TreeException;
    public void detachLeftSubtree() throws TreeException;
    public void detachRightSubtree() throws TreeException;
    public BinaryTree<T> getLeftSubtree() throws TreeException;
    public BinaryTree<T> getRightSubtree() throws TreeException;
}
