package com.example.demo.LinkedList;

public class SearchingRec {

    public static class Node {
        Node next;
        int data;
    public Node(int data){
        this.data = data;
        this.next = null;
    }    
    }

    Node head;
    Node tail;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail =newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int remove(){
        if(head== null){
            System.out.print("Empty");
            return -1;
        }

        if(head.next == null){
            int val = head.data;
            head = null;
            return val;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        return val;
    }

    //RECURSIVE SEARCH

    public int helperSearch(int key,Node head){
        // base
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }

        int idx = helperSearch(key,head.next);
        if(idx == -1){
            return -1;
        }
        return idx+1;

        //tmie comp == O(n);


    }
    public int searchingRec(int key){
       return  helperSearch(key, head);
    }


    //REVERSE A LIST
    public void reverse(){
        if(head == null){
            System.out.println("Empty");
        }
        Node curr = head;
        Node next;
        Node prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr = next;
        }
        head = prev;
    }

    //check palidrome or not
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
            
        }
        return slow;//mid
    }

    public boolean palidrome(){
        if(head == null || head.next == null){
            return true;

        }

        // step 1 mid node 

        Node mid = findMid(head);

        //step - 2 revese 2nd half
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;//right head;;
        Node left = head;

        // step3 checking

        while (right != null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
            
        }
        return true;

    }

    public static void main(String args[]){
        SearchingRec s = new SearchingRec();
        s.insert(1);
        s.insert(0);
        s.insert(1);
        // s.insert(4);

        System.out.println(s.palidrome());

       int res =  s.searchingRec(3);
       System.out.println(res);

    }
}