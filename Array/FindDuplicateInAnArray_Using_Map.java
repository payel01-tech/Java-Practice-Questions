package Array;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateInAnArray_Using_Map {
    public static void main(String args[])
    {
        int nums[]=new int[]{3,1,3,4,2};
        int res=FindDuplicateUsingMap(nums);
        System.out.println("Duplicate Value: "+res);
    }

    private static int FindDuplicateUsingMap(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        for(Map.Entry<Integer,Integer> temp: map.entrySet())
            if(temp.getValue()>1)
                return temp.getKey();
        return 0;
    }
}
