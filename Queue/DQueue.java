package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DQueue {
    public static void main(String args[])
    {
        Deque<Integer> obj = new ArrayDeque<>();

        obj.offerFirst(12);
        obj.offerLast(13);
        obj.offerLast(22);
        obj.offerFirst(21);

        System.out.println(obj.removeFirst());
        System.out.println(obj.removeLast());

        System.out.println(obj.peekFirst());
        System.out.println(obj.peekLast());
    }
}
