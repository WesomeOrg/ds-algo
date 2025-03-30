package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {
    @Test
    void testEmptyTree() {
        // Test for an empty tree (null root)
        assertEquals(0, BinaryTree.getDifferenceOfNodes(null), "difference of an empty tree should be 0");
    }

    @Test
    void testSingleNodeTree() {
        // Test for a tree with a single node
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        assertEquals(10, BinaryTree.getDifferenceOfNodes(tree.root), "difference of a single node tree should be the node's value");
    }

    @Test
    void testBalancedBinaryTree() {
        // Test for a balanced binary tree
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);
        assertEquals(29, BinaryTree.getDifferenceOfNodes(tree.root), "difference of balanced binary tree nodes should be correct");
    }

    @Test
    void testUnbalancedBinaryTree() {
        // Test for an unbalanced binary tree (sorted order insertion creating a right-skewed tree)
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        assertEquals(30, BinaryTree.getDifferenceOfNodes(tree.root), "difference of right-skewed tree nodes should be correct");
    }

    @Test
    void testTreeWithNegativeValues() {
        // Test for a tree with negative values
        BinaryTree tree = new BinaryTree();
        tree.insert(-5);
        tree.insert(-3);
        tree.insert(-2);
        tree.insert(-1);
        tree.insert(-7);
        tree.insert(-4);
        assertEquals(0, BinaryTree.getDifferenceOfNodes(tree.root), "difference of tree with negative values should be correct");
    }

    @Test
    void testLargeTree() {
        // Test for a large tree with many nodes
        BinaryTree tree = new BinaryTree();
        for (int i = 1; i <= 1000; i++) {
            tree.insert(i);
        }
        assertEquals(-500, BinaryTree.getDifferenceOfNodes(tree.root), "difference of large tree should be correct");
    }

    @Test
    void testBalancedTree() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        assertEquals(29, BinaryTree.getDifferenceOfNodes(root), "difference of large tree should be correct");

    }

    @Test
    void testBalanceTree() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        int differenceOfNodes = BinaryTree.getDifferenceOfNodes(root);
        System.out.println("differenceOfNodes = " + differenceOfNodes);
        assertEquals(60, differenceOfNodes, "difference of large tree should be correct");
    }
}