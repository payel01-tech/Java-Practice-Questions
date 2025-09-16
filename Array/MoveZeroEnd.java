package Array;

public class MoveZeroEnd {
    public static void moveZeroEnd(int nums[])
    {
        int i=0;
        for(int j=0;j<nums.length;j++) {
            if (nums[j] != 0) {
                int curr = nums[j];
                nums[j] = 0;
                nums[i] = curr;
                i += 1;
            }
        }
        for(int num:nums)
            System.out.print(num+" ");
    }
    public static void main(String args[])
    {
        int nums[]=new int[]{0,1,0,3,12};
        moveZeroEnd(nums);
    }
}
