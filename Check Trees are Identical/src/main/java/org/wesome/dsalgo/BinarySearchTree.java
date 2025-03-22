package org.wesome.dsalgo;

import lombok.Data;

import java.util.Objects;

public class BinarySearchTree {
    Node root;

    /*  Compares two binary trees to check if they are identical:   */
    boolean identicalTrees(Node a, Node b) {
        /* 1. If both trees are empty or null, they are identical. */
        if (Objects.isNull(a) && Objects.isNull(b)) {
            return true;
        }

        /* 2. If both trees are non-empty, it recursively compares */
        if (Objects.nonNull(a) && Objects.nonNull(b)) {
            return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));
        }

        /* 3. If one tree is empty and the other is not, the trees are not identical. */
        return false;
    }

    /*  Adds a new node to the tree. */
    void insert(int data) {
        System.out.println("BinarySearchTree.insert data = " + data);
        root = insert(root, data);
    }

    Node insert(Node root, int data) {
        /*  If the current root is null, it creates a new Node with the given data. */
        if (Objects.isNull(root)) {
            Node tempNode = new Node(data);
            return tempNode;
        }
        /*  If data is greater than root.data, it moves to the right subtree    */
        if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            /*  If data is smaller or equal to root.data, it moves to the left subtree  */
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