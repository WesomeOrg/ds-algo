package org.wesome.dsalgo;

import lombok.Data;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

@Data
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public static void leftView(Node root) {
        if (Objects.isNull(root)) {
            System.out.println("the root is null");
            return;
        }
        /*  Uses a level-order traversal approach with a queue. */
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        /*  Checks if the root is null and exits if true.   */
        while (!queue.isEmpty()) {
            /*  Adds the root node to a queue.  */
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                Node node = queue.poll();
                /*  For every level, the first node (i == 1) is printed.    */
                if (i == 1) {
                    System.out.print("[" + node.data + "]");
                }
                if (Objects.nonNull(node.left)) {
                    queue.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.add(node.right);
                }
            }
        }
    }

    void insert(int data) {
        System.out.println("BinarySearchTree.insert data = " + data);
        root = insert(root, data);
    }

    Node insert(Node root, int data) {
        /*  If the current root is null, a new node is created and returned.    */
        if (Objects.isNull(root)) {
            Node tempNode = new Node(data);
            return tempNode;
        }
        /*  If the data is greater than the current node's value, the method recurses to the right subtree. */
        if (data > root.data) {
            root.right = insert(root.right, data);
        }
        /*  it recurses to the left subtree.    */
        else {
            root.left = insert(root.left, data);
        }
        return root;
    }
}