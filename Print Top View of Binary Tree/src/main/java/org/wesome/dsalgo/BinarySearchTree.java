package org.wesome.dsalgo;

import lombok.Data;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeMap;

public class BinarySearchTree {
    Node root;

    public static void topView(Node root) {
        /*  If the root node is null, the method returns immediately.   */
        if (Objects.isNull(root)) {
            System.out.println("the root is null");
            return;
        }
        /*  Set the horizontal distance of the root node to 0.  */
        int hrzDis = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        // create a queue for level order traversal
        Queue<Node> queue = new LinkedList<>();
        // Assign initialized horizontal distance value to root node and add it to the queue.
        root.hrzDis = hrzDis;
        // add root with level 0
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tnode = queue.poll();
            hrzDis = tnode.hrzDis;
            // check if this is the first node for this level
            if (!map.containsKey(hrzDis)) {
                map.put(hrzDis, tnode.data);
            }
            // add left child in the queue with horizontal distance hrzDis-1.
            if (Objects.nonNull(tnode.left)) {
                tnode.left.hrzDis = hrzDis - 1;
                queue.add(tnode.left);
            }
            // add right child in the queue with horizontal distance hrzDis+1.
            if (Objects.nonNull(tnode.right)) {
                tnode.right.hrzDis = hrzDis + 1;
                queue.add(tnode.right);
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

@Data
class Node {
    int data;
    Node left;
    Node right;
    int hrzDis;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}