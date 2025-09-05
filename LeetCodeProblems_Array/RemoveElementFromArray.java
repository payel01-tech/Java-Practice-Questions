package LeetCodeProblems_Array;

public class RemoveElementFromArray {

    public static int removeElement(int[] arr,int target)
    {
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=target){
                arr[j]=arr[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String args[])
    {
        int[] input=new int[]{0,1,2,2,3,0,4,2};
        int val=2;
        int result=removeElement(input,val);
        for(int j=0;j<result;j++)
            System.out.print(input[j]+" ");
    }
}
