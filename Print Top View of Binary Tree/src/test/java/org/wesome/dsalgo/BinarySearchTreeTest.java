package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    void testTopViewSingleNode() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        BinarySearchTree.topView(tree.root);
        // Expect output: "10"
    }

    @Test
    void testTopViewBalancedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);
        BinarySearchTree.topView(tree.root);
//  Expect output: "3 5 10 15 20"
    }

    @Test
    void testTopViewSkewedLeftTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        tree.insert(7);

        BinarySearchTree.topView(tree.root);
//   Expect output: "7 8 9 10"
    }

    @Test
    void testTopViewSkewedRightTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        BinarySearchTree.topView(tree.root);
//   Expect output: "10 11 12 13"
    }

    @Test
    void testTopViewComplexTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        BinarySearchTree.topView(tree.root);
//         Expect output: "1 2 5 10 15"
    }

    @Test
    void testTopViewEmptyTree() {
        BinarySearchTree tree = new BinarySearchTree();


        BinarySearchTree.topView(tree.root);
        //         Expect output: ""
    }

    @Test
    void testTopViewUnbalancedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(4);
        tree.insert(3);
        tree.insert(20);

        BinarySearchTree.topView(tree.root);

//   Expect output: "3 4 5 10 15 20"
    }

    @Test
    void topViewTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        BinarySearchTree.topView(binarySearchTree.root);
        //   Expect output: "1 2 4 6 7"
    }
}