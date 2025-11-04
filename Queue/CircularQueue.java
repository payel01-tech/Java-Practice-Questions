package Queue;

class Queue1 {
    int front=0,rear=-1,size=0,capacity;
    int arr[];

    Queue1(int size)
    {
        this.capacity=size;
        arr=new int[size];
    }

    void push(int val)
    {
        if(size == capacity)
            System.out.println("Sorry!! Queue is full..");
        else{
            rear=(rear+1)%capacity;
            arr[rear]=val;
            size++;
            System.out.println(val + " inserted");
        }
    }

    int pop()
    {
        if(size==0)
            System.out.println("Sorry!! Queue is empty..");
        else{
            int temp = arr[front];
            front=(front+1)%capacity;
            size--;
            System.out.println(temp + " removed");
            return temp;
        }
        return -1;
    }

    void display()
    {
        if(size==0)
            System.out.println("Sorry!! Queue is empty..nothing to display..");
        else {
            for(int i=0;i<size;i++)
                System.out.print(arr[(front+i)%capacity]+" ");
        }
    }
}

public class CircularQueue {
    public static void main(String args[])
    {
        Queue1 obj = new Queue1(5);
        obj.pop();
        obj.pop();
        obj.push(2);
        obj.push(99);
        obj.push(22);
        obj.push(21);
        obj.push(9);
        obj.push(1);
        obj.pop();
        obj.pop();
        obj.display();
    }
}
