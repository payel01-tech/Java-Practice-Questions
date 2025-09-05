package LeetCodeProblems_Array;

public class ProductofArrayExceptSelf {
    public static int[] productOfArrayExceptSelf(int[] arr)
    {
       int[] ans = new int[arr.length];
       ans[0]=1;
       for(int i=1;i<arr.length;i++)
       {
           ans[i]=ans[i-1]*arr[i-1];
       }
       int suffix=1;

       for(int j=arr.length-2;j>=0;j--)
       {
           suffix*=arr[j+1];
           ans[j]*=suffix;
       }
       return ans;
    }
    public static void main(String args[])
    {
        int[] heights=new int[]{1,2,3};
        int[] productOfArray=productOfArrayExceptSelf(heights);
        System.out.println("The Product of Array except self is");
        for(int val:productOfArray)
        {
            System.out.print(val+" ");
        }
    }
}
