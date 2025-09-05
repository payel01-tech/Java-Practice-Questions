package Sorting;

public class SelectionSort {

    public static int[] selectionSort(int arr[])
    {
        int index=0;

        for(int i=0;i<arr.length-1;i++)
        {
            int min=arr[i];
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<min) {
                    min = arr[j];
                    index=j;
                }
            }
            int temp=arr[i];
            arr[i]=min;
            arr[index]=temp;
        }
        return arr;
    }

    public static void main(String args[])
    {
        int arr[]=new int[]{6,1,45,3,22};
        selectionSort(arr);
        for(int i=0;i< arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
