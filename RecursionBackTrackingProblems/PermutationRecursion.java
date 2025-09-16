package RecursionBackTrackingProblems;

import java.util.ArrayList;
import java.util.List;

public class PermutationRecursion {
    public static void getPermutation(int[] nums,int index,List<List<Integer>> ans)
    {
        if(index==nums.length)
        {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            int temp=nums[i];
            nums[i]=nums[index];
            nums[index]=temp;

            getPermutation(nums,index+1,ans);

            int temp2=nums[i];
            nums[i]=nums[index];
            nums[index]=temp2;
        }
    }
    public static List<List<Integer>> permute(int[] nums,int index,List<List<Integer>> ans) {
        getPermutation(nums,index,ans);
        return ans;
    }
    public static void main(String args[])
    {
        List<List<Integer>> result=new ArrayList<>();
        int[] arr=new int[]{1,2,3};
        result=permute(arr,0,result);
        System.out.println(result);
    }
}
