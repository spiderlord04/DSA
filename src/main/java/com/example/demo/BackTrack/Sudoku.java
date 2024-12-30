package com.example.demo.BackTrack;
public class Sudoku {

    public static boolean isSafe(int suduko[][],int row,int col, int digit){
        //column 
        for(int i = 0;i<9;i++){
            if(suduko[row][i]==digit){
                return false;
            }
        }

        //row

        for(int i = 0;i<9;i++){
            if(suduko[i][col] == digit){
                return false;
        }
        }

        //grid (formula  startrow =(row/3)*3     startcol = (col/3)*3)
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i= sr;i<sr+3;i++){
            for(int j = sc;j<sc+3;j++){
                if(suduko[i][j] == digit){
                return false;
                }
            }
        }
        return true;
    }
public static boolean sudukoSolver(int suduko[][], int row,int col){
    //base
    if(row == 9){
        return true;
    }

    //recursion
    int nextrow = row,nextcol = col+1;
    if(col+1 ==9 ){
        nextrow = row+1;
        nextcol = 0;
    }
    if(suduko[row][col] !=0){
        return sudukoSolver(suduko, nextrow, nextcol);
    }
    
    for(int digit = 1;digit<=9;digit++){

        if(isSafe(suduko,row,col,digit)){
            suduko[row][col] = digit;

            if(sudukoSolver(suduko,nextrow,nextcol)){
                return true;
            }
            suduko[row][col] = 0;

        }
    }
    return false;

}
public static void printsuduko(int suduko[][]){
    for(int i = 0;i<suduko.length;i++){
        for(int j = 0;j<suduko[i].length;j++){
            System.out.print(suduko[i][j]+" ");
        }
        System.out.println();
    }
}
    public static void main(String[] args) {
        int[][] suduko = {
    {5, 3, 0, 0, 7, 0, 0, 0, 0},
    {6, 0, 0, 1, 9, 5, 0, 0, 0},
    {0, 9, 8, 0, 0, 0, 0, 6, 0},
    {8, 0, 0, 0, 6, 0, 0, 0, 3},
    {4, 0, 0, 8, 0, 3, 0, 0, 1},
    {7, 0, 0, 0, 2, 0, 0, 0, 6},
    {0, 6, 0, 0, 0, 0, 2, 8, 0},
    {0, 0, 0, 4, 1, 9, 0, 0, 5},
    {0, 0, 0, 0, 8, 0, 0, 7, 9}
};

        if(sudukoSolver(suduko, 0, 0)){
            printsuduko(suduko);
        }else{
            System.out.println("not fuound");
        }
        
    }
}
