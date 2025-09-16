package binarySearch;

// here we have an array where the numbers are in increasing order in the column
// so we'll start searching from the last column top value or corner value/ end value of the first row
// then if the target value matches the corner value then we'll return true
// else if target value is bigger than the corner value then we'll go for second row
// or else we'll go for second last column by doing column=column-1

public class BinarySearchIn2DArrayType2 {
    public static void main(String args[])
    {
        int[][] inputArray=new int[3][];
        inputArray[0]=new int[]{1,4,7,11,15};
        inputArray[1]=new int[]{2,5,8,12,19};
        inputArray[2]=new int[]{3,6,9,16,22};
        int target=10;
        boolean result=binarySearchin2DArrayType2(inputArray,target);
        if(result)
            System.out.println("The number found");
        else
            System.out.println("The Number doesn't exist in the array");

    }

    public static boolean binarySearchin2DArrayType2(int[][] inputArray, int target) {
        int rowLength=inputArray.length-1,columnLength=inputArray[0].length-1;
        int row=0, column=columnLength;
        while(row<=rowLength && column>=0) {
            if(target==inputArray[row][column])
                return true;
            else if(target>inputArray[row][column])
                row++;
            else
                column--;
        }
        return false;
    }
}
