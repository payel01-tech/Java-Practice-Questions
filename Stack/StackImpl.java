package Stack;

import java.util.ArrayList;
import java.util.List;

class Stack{
    private List<String> ll=new ArrayList<>();
    private int top = -1;

    public void push(String data)
    {
        ll.add(data);
        top++;
    }

    public void pop()
    {
        if(top == -1)
            System.out.println("Stack Underflow");
        ll.remove(top);
        top--;
    }

    public int getTop()
    {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top;
    }

    public void printElements()
    {
        ll.forEach(num -> System.out.print(num+" "));
    }
}
public class StackImpl {
    public static void main(String args[])
    {
        Stack obj = new Stack();
        obj.push("2");
        obj.push("3");
        obj.push("4");

        obj.printElements();

        obj.pop();

        System.out.println("\nAfter Performing Pop Operation");

        obj.printElements();
    }
}
