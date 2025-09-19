package Stack;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> str = new Stack<>();
        int length = s.length();
        for (int i=0;i<length;i++)
        {
            // opening characters will always be pushed into the stack

            Character ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                str.push(ch);
            else{
                // if the closing brackets are still coming but the stack is already empty (closing brackets > opening brackets)
                if(str.size() == 0)
                    return false;
                else{
                    int top=str.size()-1;
                    Character element = str.get(top);

                    // closing characters will always be popped from the stack
                    // if the top element is a matching opening element with the closing one

                    if(ch == '}' && element == '{' ||
                       ch == ')' && element == '(' ||
                       ch == ']' && element == '[')
                    {
                        str.pop();
                    }
                    else
                        return false;
                }
            }
        }
            return str.size() == 0;
    }
    public static void main(String args[])
    {
        boolean result = isValid("({[]})");
        System.out.println(result);
    }
}
