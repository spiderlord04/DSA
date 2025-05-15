package com.example.demo.Trees;

public class CountOfNodes {
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

       public static int countofNodes(Node root){
        if(root == null){
            return 0;
        }
        int left = countofNodes(root.left);
        int right = countofNodes(root.right);
        return left+right+1;
       }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        InnerBuildTree tree = new InnerBuildTree();
        Node root = tree.buildTree(arr);
        System.out.println();
       System.out.print(tree.countofNodes(root));
    }
}   

