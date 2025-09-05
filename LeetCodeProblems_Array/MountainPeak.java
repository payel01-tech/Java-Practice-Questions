package LeetCodeProblems_Array;

public class MountainPeak {
    public static int mountainPeak(int[] nums,int start,int end)
    {
        if(start==end)
            return start;
        int mid=start+(end-start)/2;
        if(mid==0 && nums[mid]>nums[mid+1])
            return mid;
        else if(mid==0 && nums[mid]<nums[mid+1])
            return mid+1;
        else if(mid==nums.length-1 && nums[mid]>nums[mid-1])
            return mid;
        else if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
            return mid;
        else if (nums[mid]<nums[mid+1])
            return mountainPeak(nums,mid+1,end);
        else
            return mountainPeak(nums,start,mid-1);
    }
    public static void main(String args[])
    {
        int nums[]=new int[]{1,2,1,3,5,6,4};
        int index=mountainPeak(nums,0,nums.length-1);
        System.out.println("The target is in index no: "+index);
    }
}
