package com.example.demo.BackTrack;

public class Nqueen {

    //isFunction for checking where to place at correct postion
    //q--> count the no of solutions
static int count = 0;
    public static boolean isSafe(char board[][] , int row ,int col){
        //verticall upward

       for(int i = row;i>=0;i--){
        if(board[i][col] == 'Q'){
            return false;
        }
       }

       //diagonal left up

       for(int i =row, j = col;i>=0 &&j>=0;i--,j--){
        if(board[i][j] == 'Q'){
            return false;
        }
    }

        //diagonal right up
        for(int i =row,j=col;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
       
    }

    //palce karne ke leye
    public static void nqeens(char board[][],int row){
        //base
        if(row == board.length){
            //q1 ::
            // printBoard(board);
            //q2::
            count++;
            return;
        }
        for(int i = 0;i<board.length;i++){
            if(isSafe(board, row, i)){

                board[row][i] = 'Q';
                nqeens(board, row+1);
                board[row][i] = 'x';//backtracking
            }
        }
    }

    public static void printBoard(char board[][]){
        System.out.println("------chess board-------");
        for(char i[] : board){
            for(char j : i){
                System.out.print(j+" ");
            }System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for(int i = 0 ;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = 'x';

            }
        }

        nqeens(board, 0);
        System.out.println(count);
    }
    
}
