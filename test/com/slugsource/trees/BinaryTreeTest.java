package com.slugsource.trees;

import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Nathan Fearnley
 */
public class BinaryTreeTest
{

    public BinaryTreeTest()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Test
    public void TestPreOrderIterator()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(1,
                new BinaryTree<>(2,
                    new BinaryTree<>(3),
                    new BinaryTree<>(4)),
                new BinaryTree<>(5,
                    new BinaryTree<>(6),
                    new BinaryTree<>(7)));

        tree.setPreOrderIterator();

        int x = 0;
        for (Integer y : tree)
        {
            x++;
            assertEquals(x, y.intValue());
        }
    }

    @Test
    public void TestInOrderIterator()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(4,
                new BinaryTree<>(2,
                    new BinaryTree<>(1),
                    new BinaryTree<>(3)),
                new BinaryTree<>(6,
                    new BinaryTree<>(5),
                    new BinaryTree<>(7)));

        tree.setInOrderIterator();

        int x = 0;
        for (Integer y : tree)
        {
            x++;
            assertEquals(x, y.intValue());
        }
    }

    @Test
    public void TestPostOrderIterator()
    {
        BinaryTree<Integer> tree = new BinaryTree<>(7,
                new BinaryTree<>(3,
                    new BinaryTree<>(1),
                    new BinaryTree<>(2)),
                new BinaryTree<>(6,
                    new BinaryTree<>(4),
                    new BinaryTree<>(5)));

        tree.setPostOrderIterator();

        int x = 0;
        for (Integer y : tree)
        {
            x++;
            assertEquals(x, y.intValue());
        }
    }
}
