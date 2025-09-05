package Strings;

public class PalindromeCheck {
    public static boolean isPalindrome(String s)
    {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String temp="";
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.length()==1)
                return true;
            else
                temp+=s.charAt(i);
        }
        System.out.println(temp);
        if(s.equals(temp))
            return true;
        else
            return false;
    }
    public static void main(String args[])
    {
        String s = "A man, a plan, a canal: Panama";
        Boolean result=isPalindrome(s);
        if(result)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
