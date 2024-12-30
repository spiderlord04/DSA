package com.example.demo.BackTrack;
public class Nqueen3 {
    public static boolean nQueens(char board[][],int row){
        //base
        if(row == board.length){
            printBoard(board);
            return true;
        }
        //recursion
        for(int i = 0;i<board.length;i++){
           if(isSafe(board, row, i)) {
            board[row][i] = 'Q'; 
            if(nQueens(board, row+1)){
                return true;
            }
           
            board[row][i] = 'x';//backtrack;
        }
            

        }
        return false;
        

    }
    public static boolean isSafe(char board[][],int row,int col){
        //checking
        //upward
        for(int i = row;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonal upaward -right

        for(int i = row,j= col;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diagonal left

        for(int  i = row,j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("________");
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.err.println();
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char b[][] = new char[n][n];
        for(int i = 0;i<b.length;i++){
            for(int j = 0;j<b[i].length;j++){
                b[i][j] = 'x';
            }
        }
        nQueens(b, 0);
    }
}
