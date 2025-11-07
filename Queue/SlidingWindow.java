package Queue;

// we will analyze the first window 0 to k size
// when analyzing the first window, we will check if the back index element of the queue is larger or not
// why back because we want to maintain the descending order of the elements in the queue
// if not larger then we'll pop that element and after checking the entire queue we'll push that new element in the queue

// we will now analyze the rest of the windows from k to end
// while analyzing, we'll check if the indexes that are present in the queue are part of the current window or not,
// if not part of the current window then we'll simply pop out that index
// then we'll check for smaller elements and pop out those elements as well

import java.util.ArrayDeque;
import java.util.Deque;

class Solution1 {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> obj = new ArrayDeque<>();
        int[] arr = new int[nums.length-k+1];
        for(int i=0;i<k;i++)
        {
            while(obj.size()>0 && nums[obj.getLast()]<=nums[i])
                obj.removeLast();
            obj.addLast(i);
        }

        arr[0]=nums[obj.peekFirst()];

        for(int i=k,j=1;i<nums.length;i++,j++)
        {
            while(obj.size()>0 && obj.peekFirst()<=i-k)
                obj.pollFirst();
            while(obj.size()>0 && nums[obj.getLast()]<=nums[i])
                obj.removeLast();
            obj.addLast(i);
            arr[j]=nums[obj.peekFirst()];
        }
        return arr;
    }
}

public class SlidingWindow {
    public static void main(String args[])
    {
        int arr[];
        arr=Solution1.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        for(int i:arr)
            System.out.print(i+" ");
    }
}
