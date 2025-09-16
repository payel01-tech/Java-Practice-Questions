package Array;

import java.util.HashMap;

public class MajorityElement {
    public static int majorityOfElement(int[] nums)
    {
        int target=nums.length/2;
        HashMap<Integer,Integer> map=new HashMap<>();
        if(nums.length==1)
            return nums[0];
        else {
            for(int num:nums)
            {
                if(map.containsKey(num))
                {
                    int val=map.get(num);
                    map.put(num,val+1);
                    if(map.get(num)>target)
                        return num;
                }
                else {
                    map.put(num,1);
                }
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int[] arr=new int[]{2,2,1,1,1,2,2};
        System.out.println("The Majority of Element is: "+majorityOfElement(arr));
    }
}
