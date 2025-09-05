package LeetCodeProblems_Array;

public class PowerXN {

    public static double myPow(double x, int n)
    {
        long binForm=n;
        double ans=1;

        if(n<0)
        {
            binForm=-n;
            x=1/x;
        }
        while(binForm>0)
        {
            if(binForm%2==1)
                ans*=x;
            x*=x;
            binForm=binForm/2;
        }
        return ans;
    }

    public static void main(String args[])
    {
        double result=myPow(3,5);
        System.out.println("Result "+result);
    }
}
