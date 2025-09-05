package LeetCodeProblems_Array;

class MaximumSubarrayEqualToTargetBruteForceSolution{
    int[] nums;
    int target;
    MaximumSubarrayEqualToTargetBruteForceSolution(int[] val,int targetVal)
    {
        this.nums=val;
        this.target=targetVal;
    }
    int maximumSubarrayEqualToTargetBruteForceSolution()
    {
        int count=0;
        for(int start=0;start<nums.length;start++)
        {
            int sum=0;
            for(int end=start;end<nums.length;end++)
            {
                sum+=nums[end];
                if(sum==target)
                    count++;
            }
        }
        return count;
    }
}
public class MaximumSubarrayEqualToTargetBruteForce {
    public static void main(String args[])
    {
        int nums[]=new int[]{9,4,20,3,10,5};
        int target=33;
        MaximumSubarrayEqualToTargetBruteForceSolution obj=new MaximumSubarrayEqualToTargetBruteForceSolution(nums,target);
        int result=obj.maximumSubarrayEqualToTargetBruteForceSolution();
        System.out.println("The count of subArray sum that is equal to target "+target+" is equal to "+result);
    }
}
