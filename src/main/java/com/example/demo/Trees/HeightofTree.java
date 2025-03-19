package com.example.demo.Trees;
import java.util.*;
public class HeightofTree {
    
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
public static int heightofTree(Node root){
    //base cae
    if(root ==null){
        return 0;
    }
    // max of (left count , right count) + root count 
    //left count 
    int left = heightofTree(root.left);
    //right 
    int right = heightofTree(root.right);
    return Math.max(left, right)+1;

}

public static Node findSuccessorHelper(Node root,int rootVal){
    if(root == null){
        return null;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
        Node curr = q.poll();
        if(curr.left != null){
            q.add(curr.left);
        }
        if(curr.right != null){
            q.add(curr.right);
        }
        if(curr.data == rootVal){
             break;
        }
    }
    return q.peek();
  }  
       
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        InnerBuildTree tree = new InnerBuildTree();
        Node root = tree.buildTree(arr);
        System.out.println();
        System.out.println(tree.heightofTree(root));
       Node successorNode = tree.findSuccessorHelper(root,5);
       System.out.println(successorNode.data);
    }
}

    
