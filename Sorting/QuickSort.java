package Sorting;

public class QuickSort {

    public static int partition(int arr[], int start, int end)
    {
        int index=start-1, pivot=arr[end]; //-1
        for(int j=start;j<end;j++)
        {
            if(arr[j]<pivot)
            {
                index++;
                int temp=arr[index];
                arr[index]=arr[j];
                arr[j]=temp;
            }
        }
        index++;
        int temp=arr[index];
        arr[index]=arr[end];
        arr[end]=temp;

        return index;
    }

    public static void quickSort(int arr[],int start,int end)
    {
        if(start<end)
        {
            //finding pivot and placing it in correct place
            int pivotIndex = partition(arr,start,end);

            //left partition
            quickSort(arr,start,pivotIndex-1);

            //right partition
            quickSort(arr,pivotIndex+1,end);
        }
    }

    public static void main(String args[])
    {
        int[] arr = new int[]{5,8,2,9,1};
        quickSort(arr,0,arr.length-1);
        System.out.println("Array after sorting");
        for(int i =0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
