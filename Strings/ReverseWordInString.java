package Strings;

public class ReverseWordInString {
    public static void main(String args[])
    {
        String input="I love coding";
        String[] splitInput=input.split("\\s");
        String reverseOutput="";

        for(int i=splitInput.length-1;i>=0;i--)
        {
            reverseOutput=reverseOutput+splitInput[i]+" ";
        }
        System.out.println(reverseOutput);
    }
}
