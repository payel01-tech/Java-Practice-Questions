package Stack;
import java.util.Stack;

class Pair{
    public int key;
    public int value;

    Pair(){}

    Pair(int key, int val)
    {
        this.key=key;
        this.value=val;
    }
}

class MinStack {
    Stack<Pair> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        int minValue = (stack.empty() ? val : Math.min(val,stack.peek().value));
        Pair pair = new Pair(val,minValue);
        stack.push(pair);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().key;
    }

    public int getMin() {
        return stack.peek().value;
    }
}

public class MinStack_1 {
    public static void main(String args[])
    {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
