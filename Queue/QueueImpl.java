package Queue;

class Node{
    int data;
    Node next;

    Node(int val)
    {
        this.data=val;
        this.next=null;
    }
}
class MyQueue{
    Node front=null;
    Node rear=null;
    void enQueue(int value)
    {
        Node newNode=new Node(value);
        if(front==null)
        {
            this.front=newNode;
            this.rear=newNode;
        }
        else{
            rear.next=newNode;
            rear=newNode;
        }
        System.out.println(value+" Enqueued..");
    }

    int deQueue()
    {
        if(front==null)
            System.out.println("Queue is empty..Dequeue is not possible!! :(");
        else{
            int temp=front.data;
            front=front.next;
            if(front==null)
                rear=null;
            System.out.println(temp+" Dequeued..");
            return temp;
        }
        return -1;
    }

    int peek()
    {
        if(front!=null)
        {
            System.out.println(front.data+" Top Element..'");
            return front.data;
        }
        else
            return -1;
    }
}
public class QueueImpl {
    public static void main(String args[])
    {
        MyQueue obj=new MyQueue();
        obj.enQueue(5);
        obj.enQueue(6);
        obj.enQueue(7);
        obj.enQueue(8);
        obj.deQueue();
        obj.deQueue();
        obj.peek();
    }
}
