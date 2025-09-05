package LeetCodeProblems_Array;

public class RotatedSortedArray {
    public static int rotatedSortedArray(int[] arr,int target,int start,int end)
    {
        // apply binary search as it's a sorted array
        // that wil give us log(n) time complexity
        // find out mid value
        // find out the left part is sorted or right part
        // if left part is sorted then apply binary search there or else apply binary search in right

        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
                // when left part is sorted
            else if(arr[start]<=arr[mid])
            {
                if(target<arr[mid] && target>=arr[start])
                    // left
                    return rotatedSortedArray(arr,target,start,mid-1);
                else
                    // right
                    return rotatedSortedArray(arr,target,mid+1,end);
            }
            // when right part is sorted
            else{
                if(target>arr[mid] && target<=arr[end])
                    // right
                    return rotatedSortedArray(arr,target,mid+1,end);
                else
                    // left
                    return rotatedSortedArray(arr,target,start,mid-1);
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        int nums[]=new int[]{3,4,5,6,7,0,1,2};
        //int nums[]=new int[]{6,7,0,1,2,3,4,5};
        int target=3;
        int index=rotatedSortedArray(nums,target,0,nums.length-1);
        System.out.println("The target is in index no: "+index);
    }
}
