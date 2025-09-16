package Array;

public class MaximumWaterBruteForce {
    public static long maximumWater(int[] heights)
    {
        long maxHeight=Long.MIN_VALUE;
        int width=0, area=0, height=0;
        for(int i=0;i<heights.length;i++)
        {
            for(int j=i+1;j<heights.length;j++)
            {
                width=j-i;
                height=Math.min(heights[i],heights[j]);
                area=width*height;
                maxHeight=Math.max(maxHeight,area);
            }
        }
        return maxHeight;
    }
    public static void main(String args[])
    {
        int[] heights=new int[]{3,5,1,13,44,5};
        long maxHeight=maximumWater(heights);
        System.out.println("Maximum Height of Water Container is: "+maxHeight);
    }
}

