// to find the largest histogram, we'll try to find the most left smaller and most right smaller value of each indexes
// smaller value cause the width of the area of histogram controls by the smaller value
// we'll store the indexes of the values as we will use the formula
// area = height*width(ith value*(right smaller-left smaller-1))

package Stack;
import java.util.Stack;

public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> values = new Stack<>();
        int[] leftValues = new int[heights.length];
        int[] rightValues = new int[heights.length];
        int maxArea=0;

        //previous left smaller
        for(int i=0;i<heights.length;i++)
        {
            while(!values.empty() && heights[values.peek()]>=heights[i]){
                values.pop();
            }
            if(values.empty())
                leftValues[i]=-1;
            else {
                leftValues[i]=values.peek();
            }
            values.push(i);
        }

        values.clear();

        // previous right smaller
        for(int i=heights.length-1;i>=0;i--)
        {
            while(!values.empty() && heights[values.peek()]>=heights[i]){
                values.pop();
            }
            if(values.empty())
                rightValues[i]=heights.length;
            else{
                rightValues[i]=values.peek();
            }
            values.push(i);
        }

        // area calculation
        for(int i=0;i< heights.length;i++)
        {
            int currentArea = heights[i]*(rightValues[i]-leftValues[i]-1);
            maxArea=Math.max(maxArea,currentArea);
        }
        return maxArea;
    }
    public static void main(String args[])
    {
        int[] arr = new int[]{2,4};
        int maxArea = largestRectangleArea(arr);
        System.out.print("Maximum Area of Histogram is: "+maxArea);
    }
}
