package RecursionBackTrackingProblems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void combinationSumImpl(int[] arr,List<List<Integer>> result,List<Integer> temp,int target,int index) {
        //base case
        if(index==arr.length || target<0)
            return;
        if(target==0)
        {
            if(result.contains(temp)==false)
                result.add(new ArrayList<>(temp));
            return;
        }
             //adding element
             temp.add(arr[index]);
            //repeat inclusion
            combinationSumImpl(arr,result,temp,target-arr[index],index);
            //move to next element
            combinationSumImpl(arr,result,temp,target-arr[index],index+1);
            //exclusion
            temp.remove(temp.size()-1);
            //call after exclusion for next index
            combinationSumImpl(arr,result,temp,target,index+1);
    }
    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSumImpl(arr,result,temp,target,0);
        return result;
    }

    public static void main(String args[])
    {
        int arr[]=new int[]{2,3,5};
        int target=8;
        List<List<Integer>> result;
        result=combinationSum(arr,target);
        for(List<Integer> temp:result)
        {
            for(int val:temp)
                System.out.print(val+" ");
            System.out.println();
        }
    }
}
