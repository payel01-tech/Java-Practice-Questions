public class RemoveDuplicatesFromArray {

    public static void removeDuplicates(int arr[])
    {
        int j=0;
        for(int i=1;i<arr.length;i++)
        {
            int current=arr[i];
            for(j=i-1;j>=0;j--)
            {
                if(arr[j]>current)
                {
                    arr[j+1]=arr[j];
                }
                else
                    break;
            }
            arr[j+1]=current;
        }
    }

    public static void main(String args[])
    {
        int arr[]=new int[]{6,1,77,9,12};
        removeDuplicates(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
