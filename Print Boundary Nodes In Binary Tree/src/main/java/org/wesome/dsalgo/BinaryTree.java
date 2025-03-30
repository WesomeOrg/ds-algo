package org.wesome.dsalgo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
    }
}

public class BinaryTree {
    /*  check if a node is a leaf Node, i.e., if it has left and right child node, then this node will not be a boundary    */
    boolean isLeafNode(Node root) {
        var bool = Objects.isNull(root.left) && Objects.isNull(root.right);
        System.out.println("BinaryTree.isLeafNode:- " + root.data + " is leaf node " + bool);
        return bool;
    }

    /*  add Left Leaf nodes excluding Bottom leaf Node, because those will be part of the bottom boundary */
    void addLeftLeafNode(Node root, List<Integer> result) {
        Node currNode = root.left;
        while (Objects.nonNull(currNode)) {
            /*  if the current node is not a leaf node, i.e., it has a child node, then add its value into the list  */
            if (!isLeafNode(currNode)) {
                result.add(currNode.data);
            }
            /*   if the current node left exists, then move to next left else move to right    */
            if (Objects.nonNull(currNode.left)) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
    }

    /*  add right Leaf nodes excluding Bottom leaf Node in reverse order, because those will be part of the bottom boundary */
    void addRightLeafNode(Node root, List<Integer> result) {
        Node currNode = root.right;
        List<Integer> tempList = new ArrayList<>();
        while (Objects.nonNull(currNode)) {
            /*   if the current node is not a leaf node, i.e., it has child nodes, then add it to the temp list for further iteration   */
            if (!isLeafNode(currNode)) {
                tempList.add(currNode.data);
            }
            /*   if the current node right exists, then move to next right else move to left    */
            if (Objects.nonNull(currNode.right)) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }

        /*  the right leaf nodes are added in top to down or clock wise direction, but the result has to be bottom to up or anticlockwise wise direction, hence reverse the temp list   */
        result.addAll(tempList.reversed());

    }
    /*  traverse in a preorder manner, i.e., left-> root-> right, but ignore root since it has child hence it's not boundary, add bottom Leaf nodes */

    void addBottomLeafNode(Node root, List<Integer> result) {
        /*  if the node has no left and right child, then its bottom leaf node */
        if (isLeafNode(root)) {
            System.out.println("BinaryTree.addBottomLeafNode:- root = " + root.data);
            result.add(root.data);
            return;
        }
        /*  if the node has a left and right child, then it's not a bottom leaf node, so keep iterating left and right node */
        if (Objects.nonNull(root.left)) {
            addBottomLeafNode(root.left, result);
        }
        if (Objects.nonNull(root.right)) {
            addBottomLeafNode(root.right, result);
        }
    }


    List<Integer> printBinaryTreeLeaf(Node root) {
        List<Integer> list = new ArrayList<>();
        if (Objects.isNull(root)) {
            System.out.println("BinaryTree.printBinaryTreeLeaf root is null");
            return list;
        }
        /*  if root is not a leaf node, i.e., it has child nodes, add in list  */
        if (!isLeafNode(root)) {
            System.out.println("BinaryTree.printBinaryTreeLeaf root is not a leaf node");
            list.add(root.data);
        }

        /*  add left leaf nodes in the list */
        addLeftLeafNode(root, list);

        /*  add bottom leaf nodes in the list */
        addBottomLeafNode(root, list);
        /*  add left leaf nodes in the list */
        addRightLeafNode(root, list);
        return list;
    }
}

