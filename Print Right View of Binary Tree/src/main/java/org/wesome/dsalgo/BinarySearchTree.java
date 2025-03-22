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

    public static void rightView(Node root) {
        /*  If root is null, return */
        if (Objects.isNull(root)) {
            System.out.println("the root is null");
            return;
        }
        /*  Performs a level-order traversal using a queue.   */
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        /*  Iterates through the tree level by level   */
        while (!queue.isEmpty()) {
            int size = queue.size();
            /*  Tracks the size of the queue to process nodes level-wise.   */
            for (int i = 0; i < size; i++) {
                Node curr = queue.peek();
                queue.remove();
                if (i == size - 1) {
                    System.out.print("[" + curr.data + "]");
                }
                /*  Adds the left children of the current node to the queue.  */
                if (Objects.nonNull(curr.left)) {
                    queue.add(curr.left);
                }
                /*  Adds the right children of the current node to the queue.  */
                if (Objects.nonNull(curr.right)) {
                    queue.add(curr.right);
                }
            }
        }
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