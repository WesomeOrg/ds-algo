package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    @Test
    void testBottomViewSingleNode() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        BinarySearchTree.bottomView(tree.root);
//   Expect output: "10"
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
        BinarySearchTree.bottomView(tree.root);
//   Expect output: "3 5 12 15 20"
    }

    @Test
    void testBottomViewLeftSkewedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        tree.insert(7);
        BinarySearchTree.bottomView(tree.root);
//   Expect output: "7 8 9 10"
    }

    @Test
    void testBottomViewRightSkewedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        BinarySearchTree.bottomView(tree.root);
//   Expect output: "10 11 12 13"
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
        BinarySearchTree.bottomView(tree.root);
//   Expect output: "2 6 7 8 20"
    }

    @Test
    void testBottomViewEmptyTree() {
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree.bottomView(tree.root);
//   Expect output: ""
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
        BinarySearchTree.bottomView(tree.root);
//   Expect output: "3 4 5 10 18 20"
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
        BinarySearchTree.bottomView(binarySearchTree.root);
        //   Expect output: "1 2 5 7 7"
    }
}