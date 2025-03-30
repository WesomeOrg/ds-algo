package org.wesome.dsalgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }

    // Test case 1: Empty Tree
    @Test
    void testEmptyTree() {
        Node root = null;
        List<Integer> result = binaryTree.printBinaryTreeLeaf(root);
        assertTrue(result.isEmpty(), "The result should be empty for an empty tree.");
    }

    // Test case 2: Tree with only one node (Leaf node)
    @Test
    void testSingleNode() {
        Node root = new Node(1);
        List<Integer> result = binaryTree.printBinaryTreeLeaf(root);
        assertEquals(List.of(1), result, "The result should contain only the single root node.");
    }

    // Test case 3: Tree with two nodes (One parent and one child)
    @Test
    void testTwoNodes() {
        Node root = new Node(1);
        root.left = new Node(2); // left child
        List<Integer> result = binaryTree.printBinaryTreeLeaf(root);
        assertEquals(List.of(1, 2), result, "The result should contain the boundary nodes: root and the leaf node.");
    }

    // Test case 4: Simple tree with left and right subtrees
    @Test
    void testSimpleTree() {
        // Constructing the following tree:
        //         1
        //       /   \
        //      2     3
        //       \   /
        //        4 5
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(5);

        List<Integer> result = binaryTree.printBinaryTreeLeaf(root);
        assertEquals(List.of(1, 2, 4, 5, 3), result, "The result should contain the boundary nodes in anticlockwise order.");
    }

    // Test case 5: Tree with only left children (Linear Tree)
    @Test
    void testLeftLinearTree() {
        // Constructing the following tree:
        //         1
        //        /
        //       2
        //      /
        //     3
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);

        List<Integer> result = binaryTree.printBinaryTreeLeaf(root);
        assertEquals(List.of(1, 2, 3), result, "The result should contain the boundary nodes in anticlockwise order.");
    }

    // Test case 6: Tree with only right children (Linear Tree)
    @Test
    void testRightLinearTree() {
        // Constructing the following tree:
        //         1
        //          \
        //           2
        //            \
        //             3
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);

        List<Integer> result = binaryTree.printBinaryTreeLeaf(root);
        assertEquals(List.of(1, 3, 2), result, "The result should contain the boundary nodes in anticlockwise order.");
    }

    // Test case 7: Tree with both left and right children with a larger structure
    @Test
    void testLargeTree() {
        // Constructing the following tree:
        //          1
        //       /     \
        //      2       3
        //     / \     / \
        //    4   5   6   7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> result = binaryTree.printBinaryTreeLeaf(root);
        assertEquals(List.of(1, 2, 4, 5, 6, 7, 3), result, "The result should contain the boundary nodes in anticlockwise order.");
    }

    // Test case 8: Tree with all leaf nodes on the right side
    @Test
    void testAllLeafNodesRight() {
        // Constructing the following tree:
        //          1
        //           \
        //            2
        //             \
        //              3
        //               \
        //                4
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);

        List<Integer> result = binaryTree.printBinaryTreeLeaf(root);
        assertEquals(List.of(1, 4, 3, 2), result, "The result should contain the boundary nodes in anticlockwise order.");
    }

    // Test case 9: Tree with duplicate values
    @Test
    void testTreeWithDuplicateValues() {
        // Constructing the following tree:
        //          1
        //       /     \
        //      1       1
        //     / \     / \
        //    1   1   1   1
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(1);

        List<Integer> result = binaryTree.printBinaryTreeLeaf(root);
        assertEquals(List.of(1, 1, 1, 1, 1, 1, 1), result, "The result should contain all boundary nodes in anticlockwise order.");
    }


    @Test
    void testTreeWithCustomValues() {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        assertEquals(List.of(1, 2, 4, 5, 6, 7, 3), binaryTree.printBinaryTreeLeaf(root), "The result should contain the root, left boundary nodes and right boundary nodes in anticlockwise order.");
    }
}