package com.example.demo.Trees;

import java.util.Deque;
import java.util.LinkedList;

public class ZigZag {

static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

static class InnerBuildTree {
    static int idx = -1;

    public Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;

        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    /*
     * normal order :
     *   addfirst , remove last 
     * revese order mein:
     *   addlast , removefirst and add right first ,left second
     */

     public void  zigzaglevelOrder(Node root){
        if(root == null){
            return ;
        }
        Deque<Node> q = new LinkedList<>();
        q.add(root);
        boolean reverse = true;
        while (!q.isEmpty()) {
            
            //normal order
            if(!reverse){
                Node curr = q.removeFirst();
                if(curr.left != null){
                    q.addLast(curr.left);
                }if(curr.right != null){
                    q.addLast(curr.right);
                }
                System.out.println(curr.data);
            }else{
                Node curr = q.removeLast();
                if(curr.left != null){
                    q.addFirst(curr.left);
                }if(curr.right != null){
                    q.addFirst(curr.right);
                }
                System.out.println(curr.data);
            }

            reverse = !reverse;
            //reverse order
        }

     }
}

public static void main(String[] args) {
    int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    InnerBuildTree tree = new InnerBuildTree();
    Node root = tree.buildTree(arr);
    System.out.println(root.data);
   

}
}