package LeetCodeProblems_Array;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int j;
        for(int i=digits.length-1;i>=0;i--)
        {
            if(digits[i]<9)
            {
                digits[i]++;
                return digits;
            }
            else
                digits[i]=0;
        }
        int result[]=new int[digits.length+1];
        result[0]=1;
        for(j=1;j< result.length;j++)
            result[j]=0;
        return result;
    }

    public static void main(String args[])
    {
        int[] arr =  new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] res = plusOne(arr);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
    }
}
