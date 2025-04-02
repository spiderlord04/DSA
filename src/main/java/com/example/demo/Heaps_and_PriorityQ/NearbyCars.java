package com.example.demo.Heaps_and_PriorityQ;

import java.util.PriorityQueue;

public class NearbyCars {
//     Nearby Cars :
// Wr are given n points in a 2D plane which are locations of N cars if we are at the origin print the nearest K cars . 
// c0(3,3)
// c1(5,-1)
// c2(-2,4) k = 2 , and = c0 and c2

static class Car implements Comparable<Car>{
    int x;
    int y;
    int dis;
    int i;
    public Car(int x,int y ,int dis, int i){
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.i = i;
    }
    @Override
    public int compareTo(Car p1){
        //for ascending order
        return this.dis - p1.dis;
        //for descending order
        // return p1.dis - this.dis;
    }
}
public static void main(String args[]){
int car[][] = {{3,3},{5,-1},{-2,4}};
int k = 2;
PriorityQueue<Car> pq = new PriorityQueue<>();
for(int j = 0;j<car.length;j++){
int dis = (car[j][0]*car[j][0])+(car[j][1]*car[j][1]);
pq.add(new Car(car[j][0],car[j][1],dis,j));
}
Car ans[] = new Car[k];
for(int i = 0;i<k;i++){
ans[i] = pq.remove();
}
for(int i = 0;i<k;i++){
System.out.println(ans[i].x+" "+ans[i].y);
}
}
}
