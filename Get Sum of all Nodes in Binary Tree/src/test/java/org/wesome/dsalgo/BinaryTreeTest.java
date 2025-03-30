package org.wesome.dsalgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {

    private BinaryTree tree;

    @BeforeEach
    void setUp() {
        // Initialize the tree before each test
        tree = new BinaryTree();
    }

    @Test
    void testEmptyTree() {
        // Test for an empty tree (null root)
        assertEquals(0, BinaryTree.getSumOfNodes(null), "Sum of an empty tree should be 0");
    }

    @Test
    void testSingleNodeTree() {
        // Test for a tree with a single node
        tree.insert(10);
        assertEquals(10, BinaryTree.getSumOfNodes(tree.root), "Sum of a single node tree should be the node's value");
    }

    @Test
    void testBalancedBinaryTree() {
        // Test for a balanced binary tree
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);
        assertEquals(69, BinaryTree.getSumOfNodes(tree.root), "Sum of balanced binary tree nodes should be correct");
    }

    @Test
    void testUnbalancedBinaryTree() {
        // Test for an unbalanced binary tree (sorted order insertion creating a right-skewed tree)
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        assertEquals(150, BinaryTree.getSumOfNodes(tree.root), "Sum of right-skewed tree nodes should be correct");
    }

    @Test
    void testTreeWithNegativeValues() {
        // Test for a tree with negative values
        tree.insert(-5);
        tree.insert(-3);
        tree.insert(-2);
        tree.insert(-1);
        tree.insert(-7);
        tree.insert(-4);
        assertEquals(-22, BinaryTree.getSumOfNodes(tree.root), "Sum of tree with negative values should be correct");
    }

    @Test
    void testLargeTree() {
        // Test for a large tree with many nodes
        for (int i = 1; i <= 1000; i++) {
            tree.insert(i);
        }
        int expectedSum = 1000 * (1000 + 1) / 2;  // Sum of first 1000 numbers
        assertEquals(expectedSum, BinaryTree.getSumOfNodes(tree.root), "Sum of large tree should be correct");
    }

    // Additional helper method for creating a balanced tree for testing purposes
    private Node createBalancedTree() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        return root;
    }

    // Helper method to create a right-skewed tree (inserting in sorted order)
    private Node createRightSkewedTree() {
        Node root = new Node(10);
        root.right = new Node(20);
        root.right.right = new Node(30);
        root.right.right.right = new Node(40);
        root.right.right.right.right = new Node(50);
        return root;
    }
}