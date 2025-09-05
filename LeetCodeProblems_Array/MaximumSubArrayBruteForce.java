package LeetCodeProblems_Array;

public class MaximumSubArrayBruteForce {
    public static void MaximumSubArray(int[] nums)
    {
        int n=nums.length;
        int maxSum=0;
        for (int start=0;start<n;start++)
        {
            int currentSum=0;
            for(int end=start;end<n;end++)
            {
//                It will print all the subarrays of the array
//                for(int i=start;i<=end;i++)
//                {
//                    System.out.print(nums[i]);
//                }
//                System.out.print(" ");
                currentSum+=nums[end];
                maxSum=Math.max(maxSum,currentSum);
            }
            //System.out.println();
        }
        System.out.println("Maximum SubArray Sum: "+maxSum);
    }
    public static void main(String args[])
    {
        int nums[]=new int[]{1,2,3,4,5};
        MaximumSubArray(nums);
//        System.out.println("Maximum SubArray Sum: "+result);
    }
}
