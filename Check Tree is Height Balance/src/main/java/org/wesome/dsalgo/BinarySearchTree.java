package org.wesome.dsalgo;

import lombok.Data;

import java.util.Objects;

public class BinarySearchTree {
    Node root;

    /*   The tree is "height-balanced," if the left and right sides are equally deep.    */
    boolean treeIsHeightBalance(Node node) {
        /*  An empty tree is balanced. */
        if (Objects.isNull(node)) {
            return true;
        }
        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);
        return lDepth == rDepth;
    }

    int maxDepth(Node node) {
        /*  If the node is empty or node == null, the depth is 0 */
        if (Objects.isNull(node)) {
            return 0;
        } else {
            /* compute the depth of each subtree */
            /* calculates how deep the left side of the tree is. */
            int lDepth = maxDepth(node.left);

            /* calculates how deep the right side of the tree is. */
            int rDepth = maxDepth(node.right);

            /* finds which side is deeper, and adds 1 to include the current node. */
            return lDepth > rDepth ? (lDepth + 1) : (rDepth + 1);
        }
    }

    void insert(int data) {
        System.out.println("BinarySearchTree.insert data = " + data);
        root = insert(root, data);
    }

    Node insert(Node root, int data) {
        if (Objects.isNull(root)) {
            /*  If the current spot is empty (root == null), it creates a new Node with the given value.    */
            Node tempNode = new Node(data);
            return tempNode;
        }
        /*  If the value is larger, it goes to the right child  */
        if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            /*  If the value is smaller, it goes to the left child  */
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