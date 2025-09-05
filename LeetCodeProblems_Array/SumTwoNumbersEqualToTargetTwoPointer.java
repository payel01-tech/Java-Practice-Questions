package LeetCodeProblems_Array;

//The below function is applicable for sorted array
public class SumTwoNumbersEqualToTargetTwoPointer {
      public static int[] TwoSumTarget(int[] arr,int target)
      {
          int left=0, right=arr.length-1;
          int res[]=new int[2];
          while(left<right)
          {
              int current_sum=arr[left]+arr[right];
              if(current_sum==target)
              {
                  res[0]=left;
                  res[1]=right;
                  break;
              }
              else if(current_sum>target)
                  right--;
              else
                  left++;
          }
          return res;
      }

      public static void main(String args[])
      {
          int arr[] = new int[]{2,3,4};
          int target=6;
          int result[]=TwoSumTarget(arr,target);
          for(int i=0;i<result.length;i++)
              System.out.print(result[i]+" ");
      }
}
