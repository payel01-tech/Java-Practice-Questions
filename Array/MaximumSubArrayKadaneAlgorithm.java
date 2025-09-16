

package Array;

public class MaximumSubArrayKadaneAlgorithm {
    public static int MaximumSubArrayKadaneAlgorithm(int[] nums)
    {
        int currentSum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            currentSum+=nums[i];
            maxSum=Math.max(currentSum,maxSum);
            if(currentSum<0)
                currentSum=0;
        }
        return maxSum;
    }
    public static void main(String args[])
    {
        int nums[]=new int[]{3,-4,5,4,-1,7,-8};
        int result=MaximumSubArrayKadaneAlgorithm(nums);
        System.out.println("The Maximum Number is: "+result);
    }
}
