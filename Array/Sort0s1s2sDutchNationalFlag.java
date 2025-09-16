package Array;

class Sort0s1s2sDutchNationalFlagImpl{
    int[] arr;
    Sort0s1s2sDutchNationalFlagImpl(int[] val)
    {
        this.arr=val;
    }
    int[] sort0s1s2sDutchNationalFlagImpl()
    {
        int low=0,mid=0,high=arr.length-1;
        while(mid<=high)
        {
            if(arr[mid]==0)
            {
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            }
            else if(arr[mid]==1)
                mid++;
            else if (arr[mid]==2) {
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }
        }
        return arr;
    }
}
public class Sort0s1s2sDutchNationalFlag {
    public static void main(String args[])
    {
        int nums[]=new int[]{0,1,2,1,2,0,0,2,1,1};
        Sort0s1s2sDutchNationalFlagImpl obj=new Sort0s1s2sDutchNationalFlagImpl(nums);
        int[] result=obj.sort0s1s2sDutchNationalFlagImpl();
        System.out.println("The Array after Sorting");
        for(int val:result)
        {
            System.out.print(val+" ");
        }
    }
}
