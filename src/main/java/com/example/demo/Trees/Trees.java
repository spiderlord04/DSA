package com.example.demo.Trees;

public class Trees {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1 ;//for traversal..
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    //traversals................
        //1. PreOrder: root,leftsubtree,rightsubtree.

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //inorder: leftsubtree , root, rightsubtree;
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
       int nodes [] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1,-1} ;
       BinaryTree b = new BinaryTree();
       Node root = b.buildTree(nodes);
       System.out.println(root.data);
       preOrder(root);
       inorder(root);
    }


}
