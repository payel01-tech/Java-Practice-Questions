package LinkedList;

class LL{
    public class Node{
        String data;
        Node next;

        public Node(String data)
        {
            this.data=data;
            this.next=null;
        }
    }
}

class LinkedList{
    private LL.Node head;

    // insert at first
    public void addFirst(String data)
    {
        LL.Node newNode = new LL().new Node(data);
        if (head == null)
            this.head = newNode;
        else
        {
            newNode.next=head;
            head=newNode;
        }
    }

    // insert at last
    public void addLast(String data)
    {
        LL.Node newNode = new LL().new Node(data);
        if (head == null)
            this.head=newNode;
        else
        {
            LL.Node currNode = head;
            while(currNode.next != null)
            {
                currNode=currNode.next;
            }
            currNode.next=newNode;
        }
    }

    // printing all the nodes
    public void printNodes()
    {
        LL.Node currNode = head;
        while(currNode!=null)
        {
            System.out.print(currNode.data+" ");
            currNode=currNode.next;
        }
    }
}
public class LinkedListInsertion {
    public static void main(String args[])
    {
        LinkedList obj = new LinkedList();
        obj.addFirst("a");
        obj.addFirst("is");
        obj.addLast("method");
        obj.printNodes();
    }
}
