package com.example.demo.BST;
import java.util.ArrayList;

public class PrintInRange {
    //Node class for tree node
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    // print all the node in the given range
    public static ArrayList<Integer> printInRange(Node root, int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res, root, low, high);
        return res;

    }

    public static void helper(ArrayList<Integer> res, Node root, int low, int high) {
        // As it is Bst there the following 3 conditionn apply...
        // 1. If the current node's value is greater than low, recursively check the
        // left child.
        // 2. If the current node's value is within the range, add it to the result.
        // 3. If the current node's value is less than high, recursively check the right
        // child.

        if (root == null) {
            return;
        }
        if (root.data >= low && root.data <= high) {
            // check in left subtree
            helper(res, root.left, low, high);
            // and the node which are in range add them to list
            res.add(root.data);
            helper(res, root.right, low, high);
        }
        // 2
        if (root.data > high) {
            helper(res, root.left, low, high);
        } if(root.data < low) {
            helper(res,root.right, low, high);
        }
    }
    public static void main(String[] args) {
        // Create a sample BST
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(18);
        root.left.right.right= new Node(7);
        root.right.left.right = new Node(12);



        // Call printInRange to print values in the range [5, 12]
        ArrayList<Integer> result = printInRange(root, 5, 12);

        // Print the result
        System.out.println("Values in the range [5, 12]: " + result);
    }
}
