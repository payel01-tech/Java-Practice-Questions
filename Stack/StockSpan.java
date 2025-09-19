// we need to find the span of days for a particular day from when the stock prices have decreased consequetively previously including that day
// for that we need to find the recent maximum value for that day
// we will use stack data structure to store the indexes of the values
// if the stack is empty it means there are no smaller values than the recent value so span will be i+1 and
// we'll push the recent value index to stack to mark it as high value
// if the most recent value is bigger than the index value present in stack then we'll pop until we find a bigger value
// if the most recent value is lesser than the index value present in stack then we'll do i-index that is present in the stack top


package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
    public static void stockSpanImpl(int[] arr)
    {
      Stack<Integer> integerStack = new Stack<>();
      List<Integer> result = new ArrayList<>();
      int span;

      for(int i=0;i<arr.length;i++)
      {
          // Pop all smaller or equal elements
          while (!integerStack.empty() && arr[integerStack.peek()] <= arr[i])
          {
              integerStack.pop();
          }

          if (integerStack.empty())
          {
              span = i + 1; // all previous are smaller
          }
          else
          {
              span = i - integerStack.peek(); // distance from last greater
          }

          result.add(span);
          integerStack.push(i); // push current index once
      }

      System.out.println("The Span Resultant Array is");
      for(int val:result)
      {
          System.out.print(val+" ");
      }
    }
    public static void main(String args[])
    {
        int[] arr = new int[]{100,80,60,70,60,75,85};
        stockSpanImpl(arr);
    }
}
