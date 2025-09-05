package LeetCodeProblems_Array;

import java.util.ArrayList;
import java.util.List;

// we are trying to place the n queens in the n no. of columns
// then we are trying to find the safe place for n queens
// we are starting from 0 row 0 column and then calling the recursion for next row
// while backtracking we are calling the recursion for next column and 0 row

public class NQueensBackTrack {

    // here we are checking the safe place for n queens
    public static boolean isSafe(String[][]board,int startRow,int currentColumn)
    {
        //horizontal
        for(int j=0;j<board[0].length;j++)
        {
            if(board[startRow][j].equals("Q"))
                return false;
        }

        //vertical
        for(int j=0;j<board.length;j++)
        {
            if(board[j][currentColumn].equals("Q"))
                return false;
        }

        //left diagonal
        for(int i=startRow,j=currentColumn;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j].equals("Q"))
                return false;
        }

        //right diagonal
        for(int i=startRow,j=currentColumn;i>=0 && j<board[0].length;i--,j++)
        {
            if(board[i][j].equals("Q"))
                return false;
        }

        return true;
    }

    // here we are doing the recursion and the backtracking
    public static void solveNQueensImpl(String[][] board, int totalRowColumn, List<List<String>> ans, int startRow){
        if(startRow==totalRowColumn)
        {
            List<String> currentSolution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < board[i].length; j++) {
                    stringBuilder.append(board[i][j]);
                }
                currentSolution.add(stringBuilder.toString());
            }
            ans.add(currentSolution);
            return;
        }
        //main implementation
        for(int j=0;j<totalRowColumn;j++)
        {
            if(isSafe(board,startRow,j))
            {
                board[startRow][j]="Q"; // Adds the element Q at row startRow, column j.
                solveNQueensImpl(board,totalRowColumn,ans,startRow+1);
                board[startRow][j]=".";
            }
        }
    }

    // here we are defining the matrix with "." character and calling the main implementation function for n queens
    public static List<List<String>> solveNQueens(int n) {
        String[][] board=new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = "."; // fill each cell with '.'
            }
        }
        List<List<String>> nQueensFinalOutput=new ArrayList<>();
        int startRow=0;
        solveNQueensImpl(board,n,nQueensFinalOutput,startRow);
        return nQueensFinalOutput;
    }

    // here we are taking input for the matrix length and printing the final input
    public static void main(String args[])
    {
        List<List<String>> outPut=solveNQueens(4);
        for(List<String> temp:outPut)
        {
            for(String str:temp)
                System.out.print(str+" ");
            System.out.println();
        }
    }
}
