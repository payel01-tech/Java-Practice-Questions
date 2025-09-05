package LeetCodeProblems_Array;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArraySumEqualToKOptimized {
    public static void main(String args[])
    {
        int nums[]=new int[]{9,4,20,3,10,5};
        int target=33;
        int result=maximumSubarrayEqualToTargetBruteForceSolution(nums,target);
        System.out.println("The count of subArray sum that is equal to target "+target+" is equal to "+result);
    }

    private static int maximumSubarrayEqualToTargetBruteForceSolution(int[] nums, int target) {
        int[] prefixSum=new int[nums.length];
        int count=0;
        Map<Integer,Integer> freqCount=new HashMap<>();
        prefixSum[0]=nums[0];
        for(int k=1;k<nums.length;k++)
        {
            prefixSum[k]=prefixSum[k-1]+nums[k];
        }
        for(int j=0;j<nums.length;j++)
        {
            if(prefixSum[j]==target)
                count++;
            int val = prefixSum[j] - target;
            if (freqCount.containsKey(val))
                count += freqCount.get(val);
            if(!freqCount.containsKey(prefixSum[j]))
                freqCount.put(prefixSum[j],0);
            freqCount.put(prefixSum[j],freqCount.get(prefixSum[j])+1);
        }
        return count;
    }
}
