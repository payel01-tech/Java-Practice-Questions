package Stack;

public class TrapRainWaterTwoPointerApproach {
    public static int trapRainWaterImpl(int arr[])
    {
        int leftPointer = 0, rightPointer = arr.length-1, sum = 0;
        int lmax = 0, rmax = 0;

        while(leftPointer<rightPointer)
        {
            lmax=Math.max(lmax,arr[leftPointer]);
            rmax=Math.max(rmax,arr[rightPointer]);

            if(lmax<rmax)
            {
                sum+=lmax-arr[leftPointer];
                leftPointer++;
            }
            else{
                sum+=rmax-arr[rightPointer];
                rightPointer--;
            }
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
