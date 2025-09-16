package Array;

// here we are using the concept of slow fast pointer to find the duplicate element in an array
// at first, slow and fast pointer will point the same element once we initialize the value of the pointers
// we will increase the value of slow pointer by one and fast pointer by two
// until the value of slow and fast pointer point the same element
// after that we'll re-initialize the value of slow pointer by initializing it with the first value
// again we'll increment the slow and fast pointer value by 1 until the value become same
// or they point the same variable that is the repeating value
// then we'll return slow/fast pointer value

public class FindDuplicateSlowFastPointer {
    public static int FindDuplicateSlowFastPointer(int nums[])
    {
        int slow=nums[0], fast=nums[0];

        do{
            slow=nums[slow]; //slow=slow+1
            fast=nums[nums[fast]]; //fast=fast+2
        }while(slow!=fast);

        slow=nums[0];

        while(slow!=fast){
            slow=nums[slow]; //slow=slow+1
            fast=nums[fast]; //fast=fast+1
        }

        return slow;
    }

    public static void main(String args[])
    {
        int nums[]=new int[]{3,1,3,4,2};
        int res=FindDuplicateSlowFastPointer(nums);
        System.out.println("Duplicate Value: "+res);
    }
}
