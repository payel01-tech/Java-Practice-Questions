package LeetCodeProblems_Array;

public class MaxWaterContainerTwoPointers {
    public static int maximumWaterTwoPointer(int[] heights)
    {
        int maxHeight=Integer.MIN_VALUE;
        int i=0,j=heights.length-1;
        while(i<j)
            {
                int min = Math.min(heights[i], heights[j]);
                maxHeight = Math.max((j-i)*min,maxHeight);
                if(heights[i]<heights[j])
                    i++;
                else
                    j--;
            }
        return maxHeight;
    }
    public static void main(String args[])
    {
        int[] heights=new int[]{1,8,6,2,5,4,8,3,7};
        int maxHeight= maximumWaterTwoPointer(heights);
        System.out.println("Maximum Height of Water Container is: "+maxHeight);
    }
}
