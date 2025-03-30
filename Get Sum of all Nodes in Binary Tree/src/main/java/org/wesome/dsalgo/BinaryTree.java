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

    /*  The getSumOfNodes method performs a depth-first traversal, also known as preorder traversal of the binary tree, and is summing up the data values of all nodes. The getSumOfNodes method will recursively call itself until it reaches null leaf nodes, at which point it returns 0.  */
    public static int getSumOfNodes(Node node) {
        if (Objects.isNull(node)) {
            System.out.println("BinaryTree.getSumOfNodes node is null");
            return 0;
        }
        /*  add the node data to the sums of the left and right child nodes and recursively call getSumOfNodes for the left child node and getSumOfNodes for the right child node.   */
        return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
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