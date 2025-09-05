package LeetCodeProblems_Array;

public class SingleElement_SortedArray {

    public static int singleElement(int nums[],int start,int end)
    {
        int mid=0;
        if(nums.length==1)
            return nums[0];
        else {
            while(start<=end)
            {
                if(end==0 && nums[0]!=nums[1])
                    return nums[end];

                else if(start==(nums.length-1) && nums[nums.length-1]!=nums[nums.length-2])
                    return nums[end-1];

                else
                {
                    mid= start+(end-start)/2;

                    if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid-2])
                        return nums[mid];

                    else if(mid%2==0)
                    {
                        if(nums[mid]==nums[mid-1])
                            end=mid-2;
                        else
                            start=mid+2;
                    }
                    else
                    {
                        if(nums[mid]==nums[mid-1])
                            start=mid+1;
                        else
                            end=mid-1;
                    }
                }
            }
        }
        return nums[mid];
    }

    public static void main(String args[])
    {
        int[] nums=new int[]{3,3,8,8,10,11,11};
        System.out.println("The Single Element is: "+singleElement(nums,0,nums.length));
    }
}
