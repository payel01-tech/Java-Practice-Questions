package Array;

import java.util.*;

public class ThreeSumBruteForce {
    public static Set<List<Integer>> ThreeSum(int nums[],int targetSum)
    {
        Set<List<Integer>> triplet=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                for(int k=j+1;k<nums.length;k++)
                {
                    if(nums[i]+nums[j]+nums[k]==targetSum)
                    {
                       List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
                       Collections.sort(temp);
                       triplet.add(temp);
                    }
                }
            }
        }
        return triplet;
    }
    public static void main(String args[])
    {
        int nums[]=new int[]{-1,0,1,2,-1,-4};
        Set<List<Integer>> result=ThreeSum(nums,0);
        for(List<Integer> temp:result) {
            for(int val:temp)
            {
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}
