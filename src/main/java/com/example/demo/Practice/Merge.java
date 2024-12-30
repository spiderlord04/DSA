package com.example.demo.Practice;

public class Merge {
    int arr[];
    public Merge(int arr[]){
        this.arr = arr;
    }
    public  void mergesort(int arr[]){
        int st = 0;
        int end = arr.length-1;
        if(st < end){
            int mid = st+(end - st)/2;
            int left[] = new int[mid-st+1];
            int right[] = new int[end- mid];
            for(int i = 0;i<left.length;i++){
                left[i] = arr[st+i];             }
        
        for(int i = 0;i<right.length;i++){
            right[i] = arr[mid+i+1];
        }
        mergesort(left);
        mergesort(right);
        merge(arr,left,right);

    }
}
public  void merge(int arr[],int right[],int left[]){
    int i = 0;
    int j = 0;
    int k =0;
    int endl = left.length;
    int ril = right.length;
    while (i<endl && j < ril ) {
        if(left[i]<right[j]){
            arr[k] = left[i++];
        }else{
            arr[k] = right[j++];
        }
        k++;
        
    }
    //remaing elemetns fo left arr to be copyed 
    while (i<endl) {
        arr[k++] = left[i++];

    }
    //for right
    while(j<ril){
       arr[k++] = right[j++];
    }
}

public static void main(String[] args) {
    
    int arr[] = {3,8,0,9,1,5,2};
    Merge m = new Merge(arr);
    m.mergesort(arr);
    for(int i : arr){
        System.out.println(i);
    }
}

}
