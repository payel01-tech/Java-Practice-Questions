package binarySearch;

public class MountainPeak {
    public static int mountainPeak(int[] nums,int start,int end)
    {
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            //right
            else if (nums[mid]<nums[mid+1])
                return mountainPeak(nums,mid+1,end);
            //left
            else
                return mountainPeak(nums,start,mid-1);
        }
        return -1;
    }
    public static void main(String args[])
    {
        int nums[]=new int[]{1,2,1,3,5,6,4};
        int index=mountainPeak(nums,1,nums.length-2);
        System.out.println("The target is in index no: "+index);
    }
}
