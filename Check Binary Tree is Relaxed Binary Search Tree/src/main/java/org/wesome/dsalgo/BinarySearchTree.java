package org.wesome.dsalgo;

import lombok.Data;

import java.util.Objects;

public class BinarySearchTree {
    Node root;

    boolean isRelaxedBinarySearchTree(Node node, int min, int max) {
        if (node == null) {
            System.out.println("the root is null");
            return true;
        }
        /* Node value should always be greater than min and smaller then maximum */
        if (node.data < min || node.data > max) {
            return false;
        }
        /*  Recursively checks the left and right subtrees  */
        return (isRelaxedBinarySearchTree(node.left, min, node.data) && isRelaxedBinarySearchTree(node.right, node.data, max));
    }

    void insert(int data) {
        System.out.println("BinarySearchTree.insert data = " + data);
        root = insert(root, data);
    }

    Node insert(Node root, int data) {
        if (Objects.isNull(root)) {
            Node tempNode = new Node(data);
            return tempNode;
        }
        if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        return root;
    }
}

@Data
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}