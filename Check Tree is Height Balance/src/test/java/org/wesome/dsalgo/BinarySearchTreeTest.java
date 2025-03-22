package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {

    @Test
    void testEmptyTree() {
        var binarySearchTree = new BinarySearchTree();
        // Test treeIsHeightBalance on an empty tree
        assertTrue(binarySearchTree.treeIsHeightBalance(null), "An empty tree should be balanced.");
    }

    @Test
    void testSingleNodeTree() {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10); // Inserting a single node
        // Test maxDepth for a single node
        assertEquals(1, binarySearchTree.maxDepth(binarySearchTree.root), "Depth of a single node tree should be 1.");
        // Test treeIsHeightBalance for a single node
        assertTrue(binarySearchTree.treeIsHeightBalance(binarySearchTree.root), "A single node tree should be balanced.");
    }

    @Test
    void testSkewedLeftTree() {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(10); // Left-skewed tree
        // Test maxDepth for skewed tree
        assertEquals(3, binarySearchTree.maxDepth(binarySearchTree.root), "Depth of left-skewed tree should be 3.");
        // Test treeIsHeightBalance for skewed tree
        assertFalse(binarySearchTree.treeIsHeightBalance(binarySearchTree.root), "Left-skewed tree should not be balanced.");
    }

    @Test
    void testSkewedRightTree() {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(20);
        binarySearchTree.insert(30); // Right-skewed tree
        // Test maxDepth for skewed tree
        assertEquals(3, binarySearchTree.maxDepth(binarySearchTree.root), "Depth of right-skewed tree should be 3.");
        // Test treeIsHeightBalance for skewed tree
        assertFalse(binarySearchTree.treeIsHeightBalance(binarySearchTree.root), "Right-skewed tree should not be balanced.");
    }

    @Test
    void testPerfectlyBalancedTree() {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(20);
        binarySearchTree.insert(10);
        binarySearchTree.insert(30); // Balanced tree
        // Test maxDepth for balanced tree
        assertEquals(2, binarySearchTree.maxDepth(binarySearchTree.root), "Depth of a perfectly balanced tree should be 2.");
        // Test treeIsHeightBalance for balanced tree
        assertTrue(binarySearchTree.treeIsHeightBalance(binarySearchTree.root), "Perfectly balanced tree should be balanced.");
    }

    @Test
    void testImbalancedTree() {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(12); // Slightly imbalanced tree
        // Test treeIsHeightBalance for imbalanced tree
        assertFalse(binarySearchTree.treeIsHeightBalance(binarySearchTree.root), "Slightly imbalanced tree should not be balanced.");
    }

    @Test
    void testLargeTree() {
        var binarySearchTree = new BinarySearchTree();
        for (int i = 1; i <= 1000; i++) {
            binarySearchTree.insert(i); // Insert 1 to 1000
        }
        // Test maxDepth for a large tree
        assertEquals(1000, binarySearchTree.maxDepth(binarySearchTree.root), "Large skewed tree (1 to 1000) should have a depth of 1000.");
        // Test treeIsHeightBalance for large skewed tree
        assertFalse(binarySearchTree.treeIsHeightBalance(binarySearchTree.root), "Large skewed tree should not be balanced.");
    }

    @Test
    void testDuplicateInsertion() {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(50);
        binarySearchTree.insert(50);
        assertEquals(1, binarySearchTree.maxDepth(binarySearchTree.root.left), "Duplicate handling can result in depth adjustment.");
    }


    @Test
    void treeIsHeightBalanceTest() {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        assertTrue(binarySearchTree.treeIsHeightBalance(binarySearchTree.root), "Binary Search Tree Is Height Balance");
    }
}