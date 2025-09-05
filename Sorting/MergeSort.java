package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void merge(int arr[], int start,int mid,int end)
    {
        List<Integer> temp=new ArrayList<>();
        int i=start;int j=mid+1;
        while(i<=mid && j<=end) {
            if (arr[i] < arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }
        while(i<=mid)
        {
            temp.add(arr[i]);
            i++;
        }
        while(j<=end)
        {
            temp.add(arr[j]);
            j++;
        }
        for(int k=0;k<temp.size();k++)
        {
            arr[k+start]=temp.get(k);
        }
    }

    public static void mergeSort(int[] arr, int start, int end)
    {
        if(start<end)
        {
            //divide and conquer
            int mid=start+((end-start)/2);
            //left part
            mergeSort(arr,start,mid);
            //right part
            mergeSort(arr,mid+1,end);

            //merge the divided sorted array
            merge(arr,start,mid,end);
        }
    }

    public static void main(String args[])
    {
        int[] arr = new int[]{5,8,2,9,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println("Array after sorting");
        for(int i =0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
