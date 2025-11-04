package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i =0;i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))
                queue.add(i);
//            m.put(c, m.getOrDefault(c, 0) + 1);
//            Get the current count of key c from the map (or use 0 if missing),
//            then add 1, and put it back into the map.
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

            while(!queue.isEmpty() && map.get(s.charAt(queue.peek()))>1)
                queue.remove();
        }
        return (queue.isEmpty()?-1: queue.peek());
    }
}

public class StringUniqueCharacterUsingQueue {
    public static void main(String args[])
    {
        System.out.println(Solution.firstUniqChar("leetcode"));
    }
}
