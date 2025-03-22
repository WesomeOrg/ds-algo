package org.wesome.dsalgo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {
    @Test
    void testInsertSingleNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        assertNotNull(bst.root);
        assertEquals(10, bst.root.getData());
        assertNull(bst.root.getLeft());
        assertNull(bst.root.getRight());
    }

    @Test
    void testInsertMultipleNodes() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertEquals(10, bst.root.getData());
        assertEquals(5, bst.root.getLeft().getData());
        assertEquals(15, bst.root.getRight().getData());
    }

    @Test
    void testInsertDuplicateValues() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(10); // Attempt to insert duplicate
        assertNotNull(bst.root);
        assertEquals(10, bst.root.getData());
        assertNull(bst.root.getRight()); // Ensure no duplicate node is created
    }

    @Test
    void testIdenticalTreesTrue() {
        BinarySearchTree tree1 = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();

        tree1.insert(10);
        tree1.insert(5);
        tree1.insert(15);

        tree2.insert(10);
        tree2.insert(5);
        tree2.insert(15);

        assertTrue(tree1.identicalTrees(tree1.root, tree2.root));
    }

    @Test
    void testIdenticalTreesFalse() {
        BinarySearchTree tree1 = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();

        tree1.insert(10);
        tree1.insert(5);
        tree1.insert(15);

        tree2.insert(10);
        tree2.insert(5);

        assertFalse(tree1.identicalTrees(tree1.root, tree2.root));
    }

    @Test
    void testIdenticalTreesEmptyTrees() {
        BinarySearchTree tree1 = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();

        assertTrue(tree1.identicalTrees(tree1.root, tree2.root));
    }

    @Test
    void testIdenticalTreesOneEmptyTree() {
        BinarySearchTree tree1 = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();

        tree1.insert(10);

        assertFalse(tree1.identicalTrees(tree1.root, tree2.root));
    }

    @Test
    void testInsertNullEdgeCase() {
        BinarySearchTree bst = new BinarySearchTree();
        assertDoesNotThrow(() -> bst.insert(0)); // Insert a boundary case like 0
        assertEquals(0, bst.root.getData());
    }

    @Test
    void identicalTreesTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        Assertions.assertTrue(binarySearchTree.identicalTrees(binarySearchTree.root, binarySearchTree.root));
    }
}