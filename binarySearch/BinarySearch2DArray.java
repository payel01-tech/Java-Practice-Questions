package binarySearch;

// here we have a 2D array where we have numbers in increasing order
// so we will apply binary search in both row and the values of the row
// we'll find the mid row value and then we'll check for the startvalue and endvalue range of the mid value
// if target lies on those value range then we'll return true
// or else we'll check for another rows by start=mid+1 or end=mid-1

public class BinarySearch2DArray {
    public static void main(String args[])
    {
        int[][] inputArray=new int[3][];
        inputArray[0]=new int[]{10,20,30};
        inputArray[1]=new int[]{40,45,50};
        inputArray[2]=new int[]{60,79,80};

        int target=79;
        int[] index=binarySearchin2DArray(inputArray,0,inputArray.length-1,target);
        if(index.length==1)
            System.out.println("The Number doesn't exist in the array");
        else{
            System.out.println("The number found in the below row and index");
            for(int i:index)
                System.out.print(i+" ");
        }
    }

    private static int[] binarySearchin2DArray(int[][] inputArray, int start, int end,int target) {
        while(start<=end) {
            int mid = start + (end - start) / 2;
            int startvalue = inputArray[mid][0];
            int endvalue = inputArray[mid][inputArray[mid].length - 1];
            int temp;
            if (startvalue <= target && target <= endvalue)
            {
                temp=searchInRow(inputArray[mid],0,inputArray[mid].length - 1,target);
                return new int[]{mid,temp};
            }
            else if (target > endvalue)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return new int[]{0};
    }

    private static int searchInRow(int[] nums, int start, int end,int target) {
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}
