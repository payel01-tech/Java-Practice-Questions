package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToDigits {
       public static ArrayList<Integer> plusOne(ArrayList<Integer> A)
        {
            A.set(A.size()-1, A.getLast()+1);
            return A;
        }

        public static void main(String args[])
        {
            ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1,2,3));
            System.out.print(plusOne(output));
        }
}

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//
//public class Array.ArrayToDigits {
//    public static int arrayToDigits(ArrayList<Integer> A)
//    {
//        int num=0;
//        for (int i=0;i<A.size();i++)
//        {
//            num=num*10+A.get(i);
//        }
//        return num;
//    }
//
//    public static ArrayList<Integer> plusOne(ArrayList<Integer> A)
//    {
//        ArrayList<Integer> output = new ArrayList<Integer>();
//        int number = arrayToDigits(A);
//        int result = (number+1);
//        while(result>0)
//        {
//            int remainder = result%10;
//            result=result/10;
//            output.add(remainder);
//        }
//        Collections.reverse(output);
//        return output;
//    }
//
//    public static void main(String args[])
//    {
//        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1,2,3));
//        System.out.print(plusOne(output));
//    }
//}
//
