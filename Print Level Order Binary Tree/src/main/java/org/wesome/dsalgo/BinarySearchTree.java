package org.wesome.dsalgo;

import lombok.Data;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    void printLevelOrder() {
        /*  Uses a queue (LinkedList<Node>) to traverse the tree in level order (BFS).  */
        Queue<Node> queue = new LinkedList<>();
        /*  add the root node to the queue.  */
        queue.add(root);
        while (!queue.isEmpty()) {
            /*  Removes a node from the queue.   */
            Node tempNode = queue.poll();
            System.out.print("[" + tempNode.data + "]");
            /*  if left node exists, then add in the queue.  */
            if (Objects.nonNull(tempNode.left)) {
                queue.add(tempNode.left);
            }
            /*  if right node exists, then add in the queue.  */
            if (Objects.nonNull(tempNode.right)) {
                queue.add(tempNode.right);
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

@Data
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}