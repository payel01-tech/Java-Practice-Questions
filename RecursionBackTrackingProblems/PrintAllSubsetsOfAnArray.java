package RecursionBackTrackingProblems;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsetsOfAnArray {
    public static void main(String args[]) //Overall time complexity is O(2^n*n)
    {
        int[] arr=new int[]{1,2,3};
        List<List<Integer>> finalResult;
        finalResult=subsets(arr);
        for(List<Integer> val:finalResult)
        {
            for(int value:val)
                System.out.print(value+" ");
            System.out.println();
        }

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        printSubsets(nums,result,temp,0);
        return result;
    }

    public static void printSubsets(int[] arr, List<List<Integer>> result,List<Integer> ans, int i) {
        if(i==arr.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(arr[i]);
        printSubsets(arr,result,ans,i+1);
        ans.remove(ans.size()-1);
        printSubsets(arr,result,ans,i+1);
    }
}
