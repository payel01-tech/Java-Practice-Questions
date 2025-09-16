package binarySearch;

public class SearchElement {

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid=0;
        while (start<end)
        {
            mid=(start+end)/2;
            if(target==nums[mid])
                return mid;
            else if(target<nums[mid])
                end=mid-1;
            else
                start=mid+1;
        }
        return start;
    }

    public static void main(String args[])
    {
        int arr[]=new int[]{1,3,5,6};
        int target=4;
        int res=searchInsert(arr,target);
        System.out.println("The position of unique elements: "+res);
    }
}
