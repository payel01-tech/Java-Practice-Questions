package LeetCodeProblems_Array;

public class SingleNumber_UnsortedArray {
    public static int searchSingleElement(int[] nums) {
        int result=0;
        for(int num:nums)
        {
            result^=num;
        }
        return result;
    }

    public static void main(String args[])
    {
        int arr[]=new int[]{2,2,1};
        System.out.println("The non-repeitive unique element is: "+searchSingleElement(arr));
    }
}
