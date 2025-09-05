package RecursionBackTrackingProblems;

// a knight can move upto 8 directions and when it starts from
// value 0, it expects value+1 as a next target value
// so everytime we need to check if the knight is able to move from value 0 by following
// the 8 direction rule and able to find value+1 as a next target value

public class KnightsTour {
    public static boolean checkValidGridImpl(int[][] grid,int row,int column,int target) {

        if(row<0 || column<0 || row>grid.length-1 || column>grid.length-1 || grid[row][column]!=target)
            return false;
        if(target==grid.length*grid.length-1)
            return true;

        boolean ans1=checkValidGridImpl(grid,row-2,column+1,target+1);
        boolean ans2=checkValidGridImpl(grid,row-1,column+2,target+1);
        boolean ans3=checkValidGridImpl(grid,row+1,column+2,target+1);
        boolean ans4=checkValidGridImpl(grid,row+2,column+1,target+1);
        boolean ans5=checkValidGridImpl(grid,row+2,column-1,target+1);
        boolean ans6=checkValidGridImpl(grid,row+1,column-2,target+1);
        boolean ans7=checkValidGridImpl(grid,row-1,column-2,target+1);
        boolean ans8=checkValidGridImpl(grid,row-2,column-1,target+1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    public static boolean checkValidGrid(int[][] grid) {
        boolean result= checkValidGridImpl(grid,0,0,0);
        return result;
    }

    public static void main(String args[])
    {
        int[][] grid=new int[][]{
                {0,11,16,5,20},
                {17,4,19,10,15},
                {12,1,8,21,6},
                {3,18,23,14,9},
                {24,13,2,7,22}
        };
        boolean finalAns= checkValidGrid(grid);
        System.out.println(finalAns);
    }
}
