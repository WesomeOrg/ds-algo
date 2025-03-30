package org.wesome.dsalgo;

import lombok.Data;

import java.util.Objects;

@Data
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    Node root;

    public static int nodeCount(Node node) {
        if (Objects.isNull(node)) {
            System.out.println("BinaryTree.nodeCount node is null");
            return 0;
        }
        /*  If the node is not null, the method returns 1 for the current node itself, plus the result of recursively calling nodeCount for node.left and nodeCount for node.right */
        return 1 + nodeCount(node.left) + nodeCount(node.right);
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