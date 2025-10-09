// here we want to find the previous smaller element and we are finding the previous smaller element for each element from the start
// we are checking if the stack is empty, if it's empty then we are storing -1 as the previous smaller element for any element
// else if the top element of the stack is smaller than the current i-th element then we are storing that value inside the result array
// else we are popping out the greater values until the value become smaller than the current value.

package Stack;
import java.util.Stack;

public class PreviousSmallerElement {
    public static int[] PreviousSmallerElementImpl(int[] arr)
    {
        Stack<Integer> values = new Stack<>();
        int[] result = new int[arr.length];

        for(int i=0;i<arr.length;i++)
        {
            while(!values.empty() && values.peek()>=arr[i])
                values.pop();

            if(values.empty())
                result[i]=-1;
            else {
                result[i]=values.peek();
            }
            values.push(arr[i]);
        }
        return result;
    }

    public static void main(String args[])
    {
        int arr[] = new int[]{3,1,0,8,6};
        int result[]=PreviousSmallerElementImpl(arr);
        for(int val:result)
            System.out.print(val+" ");
    }
}
