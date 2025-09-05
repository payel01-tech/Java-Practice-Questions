package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    public static int[] bubbleSort(int size,int arr[])
    {
        for(int i=0;i<size-1;i++)
        {
            for(int j=0;j<size-i-1;j++)
            {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String args[])
    {

        // taking array elements from user
        int size=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        if(sc.hasNextInt())
            size=sc.nextInt();
        int arr[]=new int[size];
        for (int i=0;i<size;i++)
        {
            System.out.println("Enter the element");
            if(sc.hasNextInt())
            {
                arr[i]=sc.nextInt();
            }
        }
        int sortedArray[]=bubbleSort(size,arr);
        System.out.println("The Array "+ Arrays.toString(arr) +" after Bubble Sort is");
        for(int i=0;i<sortedArray.length;i++)
            System.out.print(sortedArray[i]+" ");
    }
}
