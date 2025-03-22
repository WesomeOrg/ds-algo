package org.wesome.dsalgo;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    @Test
    void mirrorTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.printInOrder();
        binarySearchTree.mirror(binarySearchTree.root);
        binarySearchTree.printInOrder();
    }
}