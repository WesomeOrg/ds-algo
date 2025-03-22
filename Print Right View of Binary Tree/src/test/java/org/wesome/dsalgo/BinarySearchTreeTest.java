package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BinarySearchTreeTest {

    @Test
    void testNullRoot() {
        // Test edge case: Null root (tree is empty)
        Node root = null;
        assertDoesNotThrow(() -> BinarySearchTree.rightView(root));
        // Expect no output
    }

    @Test
    void testSingleNodeTree() {
        // Test edge case: Tree with a single node
        Node root = new Node(1);
        BinarySearchTree.rightView(root);
        // Expect output: "1"
    }

    @Test
    void testCompleteBinaryTree() {
        // Test case: Complete binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        BinarySearchTree.rightView(root);
        // Expect output: "1 3 7"
    }

    @Test
    void testLeftSkewedTree() {
        // Test edge case: Left-skewed tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        BinarySearchTree.rightView(root);
        // Expect output: "1 2 3"
    }

    @Test
    void testRightSkewedTree() {
        // Test edge case: Right-skewed tree
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        BinarySearchTree.rightView(root);
        // Expect output: "1 2 3"
    }

    @Test
    void testUnevenTree() {
        // Test case: Uneven tree structure
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(5);
        BinarySearchTree.rightView(root);
        // Expect output: "1 3 5"
    }

    @Test
    void testRightViewComplexTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(12);
        binarySearchTree.insert(18);
        binarySearchTree.insert(1);
        BinarySearchTree.rightView(binarySearchTree.root);
        // Expect output: "10 15 `8 1"
    }

    /*  Binary Search Tree is every node's right subtree contains values greater than the parent node and left subtree contains values less than the parent node */
    @Test
    void rightViewTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        BinarySearchTree.rightView(binarySearchTree.root);
        // Expect output: "4 6 7"
    }
}