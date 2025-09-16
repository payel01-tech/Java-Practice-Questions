package binarySearch;

public class BinarySearch {

    public static Boolean binarySearch(int arr[],int start,int end,int element)
    {
        if(end-start==0)
            return false;
        int mid=(start+end)/2;
        if (arr[mid]==element)
            return true;
        if(arr[mid]<element)
            return binarySearch(arr,mid+1,end,element);
        if(arr[mid]>element)
            return binarySearch(arr,start,mid-1,element);
        return false;
    }

    public static void main (String args[])
    {
        int arr[] = new int[]{4,9,34,66,89};
        Boolean result = binarySearch(arr,0,arr.length,34);
        if(result)
            System.out.println("Element Found");
        else
            System.out.println("Element Not Found");
    }
}
