package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {
    @Test
    void testInsertSingleElement() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        assertNotNull(binarySearchTree.root);
        assertEquals(10, binarySearchTree.root.data);
    }

    @Test
    void testInsertMultipleElements() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        assertEquals(10, binarySearchTree.root.data);
        assertEquals(5, binarySearchTree.root.left.data);
        assertEquals(15, binarySearchTree.root.right.data);
    }

    @Test
    void testIsValidBST() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        assertTrue(binarySearchTree.isRelaxedBinarySearchTree(binarySearchTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void testIsBSTWithEmptyTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertTrue(binarySearchTree.isRelaxedBinarySearchTree(null, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void testInvalidBST() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(8);
        assertFalse(binarySearchTree.isRelaxedBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void testInsertDuplicateValues() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(10);
        assertEquals(10, binarySearchTree.root.data);
        assertNull(binarySearchTree.root.right);
    }

    @Test
    void isRelaxedBinarySearchTreeTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(7);
        assertTrue(binarySearchTree.isRelaxedBinarySearchTree(binarySearchTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}