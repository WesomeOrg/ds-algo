package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    @Test
    void testBottomViewSingleNode() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        BinarySearchTree.bottomView(tree.root);

        // Verify the bottom view for a single node
        assertEquals("10 ", outputStream.toString().trim());
    }

    @Test
    void testBottomViewBalancedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        BinarySearchTree.bottomView(tree.root);

        // Verify the bottom view for a balanced binary tree
        assertEquals("3 5 7 12 20 ", outputStream.toString().trim());
    }

    @Test
    void testBottomViewLeftSkewedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        tree.insert(7);

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        BinarySearchTree.bottomView(tree.root);

        // Verify the bottom view for a left-skewed tree
        assertEquals("7 ", outputStream.toString().trim());
    }

    @Test
    void testBottomViewRightSkewedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        BinarySearchTree.bottomView(tree.root);

        // Verify the bottom view for a right-skewed tree
        assertEquals("13 ", outputStream.toString().trim());
    }

    @Test
    void testBottomViewComplexTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);
        tree.insert(20);

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        BinarySearchTree.bottomView(tree.root);

        // Verify the bottom view for a complex tree
        assertEquals("2 6 8 15 20 ", outputStream.toString().trim());
    }

    @Test
    void testBottomViewEmptyTree() {
        BinarySearchTree tree = new BinarySearchTree();

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        BinarySearchTree.bottomView(tree.root);

        // Verify the bottom view for an empty tree
        assertEquals("", outputStream.toString().trim());
    }

    @Test
    void testBottomViewUnbalancedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(4);
        tree.insert(3);
        tree.insert(20);
        tree.insert(18);

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        BinarySearchTree.bottomView(tree.root);

        // Verify the bottom view for an unbalanced tree
        assertEquals("3 4 5 15 20 ", outputStream.toString().trim());
    }


    @Test
    void bottomViewTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(7);
        binarySearchTree.bottomView(binarySearchTree.root);
    }
}