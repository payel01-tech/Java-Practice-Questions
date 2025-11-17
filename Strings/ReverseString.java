package Strings;

public class ReverseString {
    public static void main(String args[])
    {
        String s = "Geeks for Geeks";
        String rev="";
        for(int i=s.length()-1;i>=0;i--)
        {
            rev=rev+s.charAt(i);
        }
        System.out.println("Reverse String= "+rev);
    }

    public static int dummy(int[] arr)
    {
       int temp=0;
       for(int i=1;i<arr.length;i++)
       {
           if(arr[temp]!=arr[i])
           {
               arr[temp+1]=arr[i];
               temp=temp+1;
           }
       }
       return temp+1;
    }
}
