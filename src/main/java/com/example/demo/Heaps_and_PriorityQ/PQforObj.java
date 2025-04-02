package com.example.demo.Heaps_and_PriorityQ;
//import priority que
import java.util.PriorityQueue;
public class PQforObj {
    //To perfom any kind of sorting using PQ our class must implement the comparable interface and override the compareTO method..
    
     static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        //now override the method compareTO
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
public static void main(String[] args) {
    PriorityQueue<Student> pq = new PriorityQueue<>();
    pq.add(new Student("A", 2));
    pq.add(new Student("b", 3));
    pq.add(new Student("c", 1));
    while(!pq.isEmpty()){
        System.out.println(pq.peek().name + " " + pq.peek().rank);
        pq.remove();
    }
}

}
