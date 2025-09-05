import java.math.BigInteger;

public class Factorial {
        public static String solve(int A) {
            BigInteger fact=BigInteger.ONE;
            for (int i=1;i<=A;i++)
            {
                fact=fact.multiply(BigInteger.valueOf(i));
            }
            return fact.toString();
        }
        public static void main(String args[])
        {
            String result = solve(5);
            System.out.print(result);
        }
    }
