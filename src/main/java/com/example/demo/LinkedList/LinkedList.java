package com.example.demo.LinkedList;

public class LinkedList {
    Node head;
    Node tail;
    static int size;

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //add-first
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    //add-last

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }


    //display

    public void print(){
        if(head == null){
            System.out.println("Linked List is Empyt");

            return;
        }
        Node temp =  head;
        while(temp != null){
            System.out.print(temp.data + "--> ");
            temp= temp.next;
        }

        System.out.println("null");
    }

    //adding at specified pos

    public void addAtPos(int index,int data){
        //corner case adding at zero directly
        if(index == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i<index-1) {
            temp = temp.next;
            i++;
            
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    //REMOVE OPERATIONS
    
    //i. remove first
    public int removeFirst(){
        //corner cases 1
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            //important corner case 2 . here we have to adjust head and tail 
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //removeLast
    public int removeLast(){
        //corner cases 1
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            //important corner case 2 . here we have to adjust head and tail 
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i = size-2
        Node prev = head;
        for(int i = 0 ; i<size-2;i++){
            prev= prev.next;
        }
        int val = tail.data;//prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public int itrSearch(int key){
        Node temp = head;
        int i=0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    //recursive search
    public int helper(Node head,int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1){
            return -1;
        }
        return idx+1; //backtracing
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    //REVERSING - iterative
    //for reversing 3 variables and 4 steps 
    public void reverse(){
        Node prev = null; //because befor head is no element
        Node curr = tail =  head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            //change
            prev = curr;
            curr = next;
        }

        //setting head because at last current value is null
        head = prev;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addFirst(10);
        l.addFirst(10);
        l.addLast(20);
        l.print();
        l.addAtPos(1, 80);
        l.print();
        l.removeFirst();
        l.print();
        l.removeLast();
        l.print();
        System.out.println(size);
        System.out.println(l.itrSearch(10));
        System.out.println(l.recSearch(10));
        l.reverse();
        l.print();

    
    }
}

