package LeetCodeProblems_Array;


import java.util.ArrayList;
import java.util.List;

public class Spiral2DMatrix {
    public static void main(String args[])
    {
        List<Integer> value=new ArrayList<>();
        int[][] matrix=new int[3][3];
        matrix[0]=new int[]{1,2,3};
        matrix[1]=new int[]{4,5,6};
        matrix[2]=new int[]{7,8,9};
        value=printMatrixinSpiralOrder(matrix);
        for(int i:value)
            System.out.print(i);
    }

    public static List<Integer> printMatrixinSpiralOrder(int[][] matrix) {
        int startRow=0,endRow= matrix.length-1;
        int startColumn=0,endColumn=matrix[0].length-1;
        List<Integer> result=new ArrayList<>();
        while(startRow<=endRow && startColumn<=endColumn)
        {
            //top
            for(int i=startColumn;i<=endColumn;i++)
                result.add(matrix[startRow][i]);

            //right
            for(int i=startRow+1;i<=endRow;i++)
                result.add(matrix[i][endColumn]);

            //bottom
            for(int i=endColumn-1;i>=startColumn;i--)
            {
                if(startRow==endRow)
                    break;
                result.add(matrix[endRow][i]);

            }

            //left
            for(int i=endRow-1;i>=startRow+1;i--)
            {
                if(startColumn==endColumn)
                    break;
                result.add(matrix[i][startColumn]);
            }

            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }
        return result;
    }
}
