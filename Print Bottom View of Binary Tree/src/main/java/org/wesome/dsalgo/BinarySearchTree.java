package org.wesome.dsalgo;

import lombok.Data;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeMap;

@Data
class Node {
    int data;
    int hrzDis;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public static void bottomView(Node root) {
        System.out.println("the root is null");
        if (Objects.isNull(root)) {
            return;
        }
        int hrzDis = 0;
        /*  A TreeMap to store nodes by their horizontal distance. */
        Map<Integer, Integer> map = new TreeMap<>();
        // First add nodes in Queue for level order traversal
        Queue<Node> queue = new LinkedList<>();
        // Assign initialized horizontal distance value to root node and add it to the queue.
        root.hrzDis = hrzDis;
        queue.add(root);
        while (!queue.isEmpty()) {
            /*  Remove (poll) the front node from the queue.    */
            Node node = queue.remove();
            /*  Retrieve the node's horizontal distance (hrzDis).   */
            hrzDis = node.hrzDis;
            /*  Add or Update the node's data in the TreeMap for the current horizontal distance; this ensures the bottom-most node at that hrzDis is recorded.   */
            map.put(hrzDis, node.data);
            // add left child in the queue with horizontal distance hrzDis-1.
            if (Objects.nonNull(node.left)) {
                node.left.hrzDis = hrzDis - 1;
                queue.add(node.left);
            }
            // add right child in the queue with horizontal distance hrzDis+1.
            if (Objects.nonNull(node.right)) {
                node.right.hrzDis = hrzDis + 1;
                queue.add(node.right);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
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