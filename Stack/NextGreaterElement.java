// here we want to find the next greater element and we are finding the next greater element for each element from the end
// we are checking if the stack is empty, if it's empty then we are storing -1 as the next greater element for any element
// else if the top element of the stack is greater than the current i-th element then we are storing that value inside the result array
// else we are popping out the smaller values until the value become greater than the current value.

package Stack;

import java.util.Stack;

public class NextGreaterElement {
    public static int[] NextGreaterElementImpl(int arr[])
    {
        Stack<Integer> values = new Stack<>();
        int result[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
//            if(values.empty())
//                result[i]=-1;
//            else {
//                int temp=values.pop();
//                if(temp>arr[i])
//                    result[i]=temp;
//                else
//                    result[i]=-1;
//            }
//            values.push(arr[i]);

            // Pop all smaller or equal elements
            while (!values.isEmpty() && values.peek() <= arr[i]) {
                values.pop();
            }

            // If stack is empty → no greater element
            if (values.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = values.peek();
            }

            // Push current element
            values.push(arr[i]);

        }
        return result;
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{6,8,0,1,3};
        int result[]=NextGreaterElementImpl(arr);
        for(int val:result)
            System.out.print(val+" ");
    }
}
