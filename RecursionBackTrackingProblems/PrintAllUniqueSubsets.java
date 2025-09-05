package RecursionBackTrackingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllUniqueSubsets {
    public static void main(String args[]) //Overall time complexity is O(2^n*n)
    {
        int[] arr=new int[]{1,2,2};
        List<List<Integer>> finalResult;
        Arrays.sort(arr);
        finalResult=subsetsWithDup(arr);
        for(List<Integer> val:finalResult)
        {
            for(int value:val)
                System.out.print(value+" ");
            System.out.println();
        }

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
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
        int index=i+1;
        while(index<arr.length && arr[index]==arr[index-1]){
            index++;
        }
        printSubsets(arr,result,ans,index);
    }
}
