package LeetCodeProblems_Array;

// we need to allocate pages to M no. of student so that the number of maximum allocated pages will be minimum
// we will apply binary search for this problem
// first we will find the range of the numbers where our answer can lie
// for that we can start from 0 and the end range will be the sum of the all pages
// then we will check if the mid value is valid or not
// if valid then we will go left to check if any other answers can be valid as we need to find the minimum value of maximum allocated pages
// if invalid we will go right to check for other valid answers

class BookAllocationMethodClass{
    int[] nums;
    int studentNumbers;
    BookAllocationMethodClass(int[] arr,int number)
    {
        this.nums=arr;
        this.studentNumbers=number;
    }
    boolean isValid(int val)
    {
        int student=1,pages=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>val)
                return false;
            else if(pages+nums[i]<=val)
            {
                pages+=nums[i];
            }
            else{
                student++;
                pages=nums[i];
            }
        }
        if(student>studentNumbers)
            return false;
        else
            return true;
    }
    int allocatedBooks()
    {
        int start=0,end=0;
        for(int i=0;i<nums.length;i++)
        {
            end+=nums[i];
        }
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(isValid(mid))
                end=mid-1;
            else
                start=mid+1;

        }
        return start;
    }
}

public class BookAllocation {
    public static void main(String args[])
    {
        int nums[]=new int[]{15,17,20};
        int totalStudents=2;
        BookAllocationMethodClass obj=new BookAllocationMethodClass(nums,totalStudents);
        int result=obj.allocatedBooks();
        System.out.println("The minimum of maximum allocated pages within "+totalStudents+" no. of students is: "+result);
    }
}
