package com.example.demo.Queues;

public class QWithLL {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node head;//front
    static Node tail;//rear
    public  boolean isEmpty(){
        return head == null && tail == null;
    }
    public  void add(int data){
        Node newNode = new Node(data);
        //if 1st node
        if(head == null){
            head = tail = newNode;
            return;
        }
        //already nodes exits
        tail.next = newNode;
        tail = newNode;


    }
    public  int remove(){
        if(isEmpty()){
            return -1;
        }
        int val  = head.data;
        //if single element 
        if(tail == head) {
            tail= head= null;
        }else{
            head = head.next;
        }
        return val;
    }

    public static void main(String[] args) {
        QWithLL q = new QWithLL();

        q.add(10);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.remove();
        while (!q.isEmpty()) {
            System.out.println(q.remove());
            
        }
    }

    //NOTE
    /*
     * Time Com
     * Add - O(1)
     * remove - O(1);
     * peek - O(1)
     */


    
}
