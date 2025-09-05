package LeetCodeProblems_Array;

import java.util.HashSet;
import java.util.Set;

public class RepeatandMissingNumber2DArray {

    public static int[] RepeatandMissingNumber(int[][] nums)
    {
        Set<Integer> temp=new HashSet<>();
        int[] result= new int[2];
        int actualSum=0, expectedSum=0;
        int n=nums.length;

        for(int i=0;i<nums.length;i++)
        {
            for(int val:nums[i])
            {
                actualSum+=val;
                if(temp.contains(val))
                {
                    result[0]=val;
                }
                else{
                    temp.add(val);
                }
            }
        }
        int repeatNumber=result[0];
        expectedSum= (n*n)*(n*n+1)/2;
        int missingNumber= expectedSum+repeatNumber-actualSum;
        result[1]=missingNumber;
        return result;
    }

    public static void main(String args[])
    {
        int[][] nums={{9,1,7},{8,9,2},{3,4,6}};
        int[] result=RepeatandMissingNumber(nums);
        for(int val:result)
            System.out.print(val+" ");
    }
}
