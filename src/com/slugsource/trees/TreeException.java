package com.slugsource.trees;

/**
 *
 * @author Nathan Fearnley
 */
public class TreeException extends RuntimeException
{

    /**
     * Creates a new instance of
     * <code>TreeException</code> without detail message.
     */
    public TreeException()
    {
    }

    /**
     * Constructs an instance of
     * <code>TreeException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public TreeException(String msg)
    {
        super(msg);
    }
}
