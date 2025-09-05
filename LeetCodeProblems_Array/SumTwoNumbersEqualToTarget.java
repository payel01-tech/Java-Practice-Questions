package LeetCodeProblems_Array;

import java.util.HashMap;

public class SumTwoNumbersEqualToTarget {
    public static int[] TwoSumTarget(int arr[],int target)
    {
        HashMap<Integer,Integer> result = new HashMap<>();
        int temp=0;
        for(int i=0;i<arr.length;i++)
        {
            temp=target-arr[i];

            if(result.containsKey(temp))
            {
                //here we are storing the index of the array elements that are equal to target
                return new int[]{result.get(temp),i};
            }
            result.put(arr[i],i);
        }
        return new int[]{-1};
    }

    public static void main(String args[])
    {
        int input[]=new int[]{-3,4,3,90};
        int target=9;
        int arr[]=TwoSumTarget(input,target);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
