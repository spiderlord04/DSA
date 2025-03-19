package com.example.demo.Trees;

public class BuildTree {
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

        // inordet
        public void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // pre order
        public void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            inorder(root.left);
            inorder(root.right);
        }

        // post order
        public void postOrder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            inorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        InnerBuildTree tree = new InnerBuildTree();
        Node root = tree.buildTree(arr);
        System.out.println(root.data);
        tree.inorder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.preOrder(root);
        System.out.println();

    }
}
