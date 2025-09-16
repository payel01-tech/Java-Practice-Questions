package Array;

public class RemoveDuplicatesFromArray {
    public static int removeDuplicates(int[] nums) {
        int temp=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[temp]!=nums[i])
            {
                temp=temp+1;
                nums[temp]=nums[i];
            }
        }
        return temp+1;
    }
    public static void main(String args[])
    {
        int arr[]=new int[]{0,0,1,1,1,1,1,5,6,7,7,7,7};
        int res=removeDuplicates(arr);
        System.out.println("Output after removing duplicates");
        System.out.println("The number of unique elements: "+res);
        for(int i=0;i<res;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
