package org.wesome.dsalgo;

import lombok.Data;

import java.util.Objects;

public class BinarySearchTree {
    Node root;

    Node mirror(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        /* swap the left and right subtree */
        node.left = right;
        node.right = left;
        return node;
    }

    /* Inorder -> Left -> Root -> Right */
    void printInOrder() {
        System.out.println("print In Order");
        printInOrder(root);
    }

    void printInOrder(Node root) {
        if (Objects.isNull(root)) {
            return;
        }
        printInOrder(root.left);
        System.out.print(" " + root.data);
        printInOrder(root.right);
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