package Array;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray {
    public static void mergeSortedArray(int num1[],int m,int num2[],int n)
    {
        List<Integer> temp = new ArrayList<>();
        int i=0, j=0;
        while(i<m && j<n)
        {
            if(num1[i]<num2[j])
            {
                temp.add(num1[i]);
                i++;
            }
            else
            {
                temp.add(num2[j]);
                j++;
            }
        }
        while(i<m)
        {
          temp.add(num1[i]);
          i++;
        }
        while(j<n)
        {
            temp.add(num2[j]);
            j++;
        }

        for(int k=0;k<temp.size();k++)
            num1[k]=temp.get(k);
        for(int num:num1)
            System.out.print(num+" ");
    }
    public static void main(String args[])
    {
        int num1[]=new int[]{1,2,3,0,0,0};
        int num2[]=new int[]{2,5,6};
        mergeSortedArray(num1,3,num2,3);
    }
}
