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

    static void getLevelDiffHelper(Node root, int level, int[] oddSum, int[] evenSum) {
        // Base case: If the node is null, return
        if (root == null) {
            return;
        }

        // Add to oddSum or evenSum based on the level
        if (level % 2 != 0) {
            oddSum[0] += root.data;
        } else {
            evenSum[0] += root.data;
        }

        // Recur for left and right children with
        // incremented level
        getLevelDiffHelper(root.left, level + 1, oddSum, evenSum);
        getLevelDiffHelper(root.right, level + 1, oddSum, evenSum);
    }


    /*  The getDifferenceOfNodes method performs a depth-first traversal, also known as preorder traversal of the binary tree, and is subtracting the data values of all nodes. The getDifferenceOfNodes method will recursively call itself until it reaches null leaf nodes, at which point it returns 0.  */
    public static int getDifferenceOfNodes(Node node) {
        if (Objects.isNull(node)) {
            System.out.println("BinaryTree.getDifferenceOfNodes root node is empty");
            return 0;
        }
        int[] oddSum = {0}, evenSum = {0};

        // Start the recursion from level 1
        getLevelDiffHelper(node, 1, oddSum, evenSum);

        // Return the difference between odd
        // and even sums
        return oddSum[0] - evenSum[0];
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