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

    // delete at first
    public void deleteFirst()
    {
        if(head == null)
            System.out.println("The LinkedList is empty");
        else{
            LL.Node temp = head;
            head = temp.next;
        }
    }

    // delete at last
    public void deleteLast()
    {
        if(head == null)
            System.out.println("The LinkedList is empty");
        else{
            LL.Node temp = head;
            while(temp.next.next != null)
            {
                temp=temp.next;
            }
            temp.next=null;
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
        System.out.println("After Inserting All Nodes");
        obj.printNodes();
        obj.deleteFirst();
        obj.deleteLast();
        System.out.println("After Deleting First and Last Nodes");
        obj.printNodes();
    }
}
