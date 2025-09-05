package LeetCodeProblems_Array;

// here we need to find the minimum time that will be required to complete the painting of all the boards
// here also we'll find the range where we'll apply the binary search
// starting range value will be maximum value of the array and maximum number will be sum of all the values
// then we'll find the mid value and check if the mid value is a valid
// if valid we'll check for smaller values by doing end=mid-1
// if not valid we'll check for larger values by doing start=mid+1

class PainterPartitionTime{
    int[] nums;
    int painterNumbers;
    PainterPartitionTime(int[] arr, int number)
    {
        this.nums=arr;
        this.painterNumbers=number;
    }
    boolean isValid(int val)
    {
        int painter=1,board=0;
        for(int i=0;i<nums.length;i++) //O(n)
        {
            if(nums[i]>val)
                return false;
            else if(board+nums[i]<=val)
            {
                board+=nums[i];
            }
            else{
                painter++;
                board=nums[i];
            }
        }
        if(painter>painterNumbers)
            return false;
        else
            return true;
    }
    int allocatedBoardsToPaint()
    {
        int end=0,start=0;
        for(int i=0;i<nums.length;i++) //O(n)
        {
            start=Math.max(start,nums[i]);
            end+=nums[i];
        }
        while(start<=end) //O(log(range/sum of the all possible values))*n) as we are calling isValid for all values
        {
            int mid=start+(end-start)/2;
            if(isValid(mid))
                end=mid-1;
            else
                start=mid+1;

        }
        return start;
    }
}

public class PainterPartition {
    public static void main(String args[])
    {
        int nums[]=new int[]{40,30,10,20};
        int totalPainters=2;
        PainterPartitionTime obj=new PainterPartitionTime(nums,totalPainters);
        int result=obj.allocatedBoardsToPaint();
        System.out.println("The minimum of maximum time required to paint by "+totalPainters+" painters is: "+result);
    }
}

