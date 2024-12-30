package Recursion;

public class FirstOccurance {
    public static int firstoccuridx(int arr[],int i,int key){
        if(i == arr.length-1){
            return -1;
        }

        if(arr[i] ==key ){
            return i;
        }
        return firstoccuridx(arr, i+1, key);
    }

    public static int lastOccurance(int arr[] ,int key,int i){
        //base 
        if(i == arr.length-1){
            return -1;
        }
        //step 1 : look forward
        int isFound = lastOccurance(arr, key, i+1);

        if(isFound == -1&& arr[i] == key ){
            return i;
        }
        //step2 : check with self
        // if(arr[i] == key){
        //     return i;
        // }
        return isFound;
        
        
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,5,6};
        int res = lastOccurance(arr, 5,0);
        System.out.println(res);
    }
}
