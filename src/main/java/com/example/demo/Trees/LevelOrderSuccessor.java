package com.example.demo.Trees;

import com.example.demo.Trees.BuildTree.*;
import java.util.*;
public class LevelOrderSuccessor {
//   public static int findSuccessorHelper(Node root,int rootVal){
//     if(root == null){
//         return -1;
//     }
//     Queue<Node> q = new LinkedList<>();
//     q.add(root);
//     while (!q.isEmpty()) {
//         Node curr = q.poll();
//         if(curr.left != null){
//             q.add(curr.left);
//         }
//         if(curr.right != null){
//             q.add(curr.right);
//         }
//         if(curr.data == rootVal){
//             return q.poll().data;
//         }
//     }
//     return -1;
//   }  

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
