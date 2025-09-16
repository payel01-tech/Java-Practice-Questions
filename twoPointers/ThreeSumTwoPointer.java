package twoPointers;

import java.util.*;

public class ThreeSumTwoPointer {
    public static Set<List<Integer>> threeSumTwoPointer(int[] nums, int targetSum) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> triplet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
                if(i>0 && nums[i]==nums[i-1])
                    continue;
                int j = i + 1, k = n - 1;
                while (j<k) {
                    int sum=nums[i]+nums[j]+nums[k];
                    if (sum == targetSum) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.add(temp);
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    } else if (sum > targetSum) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        return triplet;
    }

    public static void main(String args[]) {
        int[] arr = new int[]{-2,0,1,1,2};
        Set<List<Integer>> result = threeSumTwoPointer(arr, 0);
        for (List<Integer> temp : result) {
            for (int val : temp) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
