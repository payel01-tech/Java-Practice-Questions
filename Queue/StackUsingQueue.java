package Queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        while(!q1.isEmpty())
           q2.add(q1.remove());
        q1.add(x);
        while(!q2.isEmpty())
            q1.add(q2.remove());
        System.out.println(x+" pushed");
    }
    public int pop() {
        if(!q1.isEmpty())
        {
            System.out.println(q1.peek()+" removed");
            return q1.remove();
        }
        else
        {
            System.out.println("Sorry Queue is empty");
            return -1;
        }
    }

    public int top() {
        if(!q1.isEmpty())
            return q1.peek();
        else
            return -1;
    }
    public boolean empty() {
       return (q1.isEmpty());
    }

    public void display()
    {
        System.out.println(q1);
    }
}
public class StackUsingQueue {
    public static void main(String args[])
    {
        MyStack obj = new MyStack();
        obj.pop();
        obj.pop();
        obj.push(2);
        obj.push(99);
        obj.push(22);
        obj.push(21);
        obj.push(9);
        obj.push(1);
        obj.display();
        obj.pop();
        obj.pop();
        obj.display();
    }
}
