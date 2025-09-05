package LeetCodeProblems_Array;

import java.util.Arrays;

// here we need to find the largest value of minimum distance
// for that we need to find the range from minimum distance to maximum distance of placing the cows
// minimum distance will be one and maximum distance will be maximum value-minimum value
// once we get the range then we can apply binary search on the range
// for each mid value we can check if the mid is possible
// if possible then we can check on the right side that if other than the possible mid
// if there are other possible mid values by doing start=mid+1
// if not possible then we can check on the left side as if a bigger value is not possible then
// we must need a smaller value

// To find the possible values we need to check if
// we are able to assign that minimum distance value to every cows
// for that we need to find the difference of the values that are greater than equal to the mid value
// then we need to check if the assigned cow numbers are equal to the inputted cow numbers



class AggresiveCowsDistance{
    int[] nums;
    int cowNumbers;
    AggresiveCowsDistance(int[] arr, int number)
    {
        Arrays.sort(arr);
        this.nums=arr;
        this.cowNumbers=number;
    }
    boolean isValid(int val)
    {
        int cow=1,distance=nums[0];
        for(int i=1;i<nums.length;i++) //O(n)
        {
           if(nums[i]-distance>=val)
           {
               cow++;
               distance=nums[i];
           }
        }
        if(cow==cowNumbers)
            return true;
        else
            return false;
    }
    int aggresiveCowsDistanceCalculation()
    {
        int end=0,start=1,max=0, result=-1;
        for(int i=0;i<nums.length;i++) //O(n)
        {
            max=Math.max(max,nums[i]);
        }
        end=max-start;
        while(start<=end) //O(log(range/sum of the all possible values))*n) as we are calling isValid for all values
        {
            int mid=start+(end-start)/2;
            if(isValid(mid)) {
                result = mid;
                start = mid + 1;
            }
            else
                end=mid-1;
        }
        return result;
    }
}

public class AggresiveCows {
    public static void main(String args[])
    {
        int nums[]=new int[]{1,2,8,4,9};
        int totalCows=3;
        AggresiveCowsDistance obj=new AggresiveCowsDistance(nums,totalCows);
        int result=obj.aggresiveCowsDistanceCalculation();
        System.out.println("The maximum of minimum distance between "+totalCows+" cows is: "+result);
    }
}
