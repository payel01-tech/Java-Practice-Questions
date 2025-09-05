package RecursionBackTrackingProblems;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {
    public static void main(String args[])
    {
        int[][] board = {
                {1,0,1,0,1},
                {1,1,0,0,1},
                {1,1,1,0,0}
        };
        List<String> ans = new ArrayList<>();
        String path="";
        ratMazeImpl(board,ans,0,0,path);
        for(String str:ans)
            System.out.println(str);
    }

    public static void ratMazeImpl(int[][] board,List<String> ans,int row,int column,String path) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] == -1)
            return;
        if(board[row][column]==0)
            return;
        if(row==board.length-1 && column==board.length-1)
        {
            ans.add(path);
            return;
        }
        board[row][column]=-1;
        //down
        ratMazeImpl(board,ans,row+1,column,path.concat("D"));
        //up
        ratMazeImpl(board,ans,row-1,column,path.concat("U"));
        //left
        ratMazeImpl(board,ans,row,column-1,path.concat("L"));
        //right
        ratMazeImpl(board,ans,row,column+1,path.concat("R"));
        board[row][column]=1;
    }
}
