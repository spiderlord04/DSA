package com.example.demo.ArrayList;
import java.util.*;;
public class PairSum2 {
//   Q: Pair sum of the sorted and rotated array
public static boolean pairSum2(ArrayList<Integer> list,int target){
   int breakpoint= -1;
   for(int i = 0;i<list.size()-1;i++){
    if(list.get(i)>list.get(i+1)){
        breakpoint = i;
        break;
    }

   }
   int n = list.size() ;
   int lp = breakpoint+1;
   int rp = breakpoint;
   while (lp!=rp) {
    if(list.get(lp) + list.get(rp)== target){
        return true;
    }else if(list.get(lp) +list.get(rp) < target){
        lp = (lp+1)%n;
    }else{
        rp = (rp+n-1)%n;
    }
    
   }
   return false;
}
public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(11);
    list.add(15);
    list.add(6);
    list.add(8);
    list.add(9);
    list.add(10);
    int target = 16;
    System.out.println(pairSum2(list,target));
}
}
