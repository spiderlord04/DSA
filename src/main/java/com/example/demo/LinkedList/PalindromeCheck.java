package com.example.demo.LinkedList;

public class PalindromeCheck {
    Node head;
    Node tail;
    static int size;
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //adding 
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;

        }
        newNode.next = head;
         head = newNode;
         return;
    }

    //addLast
    public void addLast(int data){
         Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        return;
    }

    //size cal
    public int sizeOfList(){
        Node temp = head;
        int sz = 0;
        while(temp != null){
            sz++;
            temp= temp.next;
        }
        return sz;
    }
    //remove 
    public int removeFirst(){
        int sz = sizeOfList();
        if(sz == 0){
            System.out.println("Empty");
            return Integer.MIN_VALUE;

        }else if(sz == 1){
            int val = head.data;
            head = tail = null;
            // size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        // size--;
        return val;
    }

    public int removeLast(){
        int sz = sizeOfList();
        if(sz == 0){
            System.out.println("Empty");
            return Integer.MIN_VALUE;

        }else if(sz == 1){
            int val = head.data;
            head = tail = null;
            // size = 0;
            return val;
        }
        Node prev = head;
        for(int i =0;i<sz-2;i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        return val;
    }
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


    //palindrome

    // step 1: midNOde
    // step2: half reverse
    // step 3: check left and right
    public Node midNode(Node head){
        Node s = head;
        Node f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    public boolean palindromeCheck(){
        if(head == null || head.next == null){
            return true;
        }

        // step 1:
        Node mid = midNode(head);
        // step2
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        //steo 3
        while(right != null){
            if(right.data != left.data){
                return false;
            }
            left= left.next;
            right = right.next;
        }
        return true;

    }

    public static void main(String[] args) {
        PalindromeCheck l = new PalindromeCheck();
        l.addFirst(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(1);
        l.print();
        // l.addAtPos(1, 80);
        l.print();
        l.print();
        System.out.print(l.palindromeCheck());
}
}