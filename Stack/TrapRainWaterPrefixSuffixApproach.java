package Stack;

public class TrapRainWaterPrefixSuffixApproach {
    public static int trapRainWaterImpl(int arr[])
    {
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        int sum=0;

        leftMax[0] = arr[0];
        rightMax[arr.length-1] = arr[arr.length-1];

        for(int i = 1;i< arr.length;i++)
        {
            if(leftMax[i-1]>arr[i])
                leftMax[i]=leftMax[i-1];
            else
                leftMax[i]=arr[i];
        }

        for(int i = arr.length-2;i>=0;i--)
        {
            if(rightMax[i+1]>arr[i])
                rightMax[i]=rightMax[i+1];
            else
                rightMax[i]=arr[i];
        }

        for(int i=0;i< arr.length;i++)
        {
            sum+=Math.min(leftMax[i],rightMax[i])-arr[i];
        }

        return sum;
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{4,2,0,3,2,5};
        int total = trapRainWaterImpl(arr);
        System.out.print("Total Trapped Rain Water: " + total);
    }
}
