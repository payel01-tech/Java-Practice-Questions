package LeetCodeProblems_Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReturnTrueIfDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        for(int i:nums)
        {
            if(temp.contains(i))
                return true;
            else
                temp.add(i);
        }
        return false;
    }

    public static void main(String args[])
    {
        int[] input=new int[]{1,2,3,1};
        System.out.println("The array contains duplicate value? "+containsDuplicate(input));
    }
}
