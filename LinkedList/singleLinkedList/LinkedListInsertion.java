package LinkedList.singleLinkedList;

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
    private int size;

    public LinkedList()
    {
        this.size=0;
    }

    public LL.Node getHead()
    {
        return head;
    }

    // insert at first
    public void addFirst(String data)
    {
        LL.Node newNode = new LL().new Node(data);
        this.size++;

        if (head == null)
            this.head = newNode;
        else
        {
            newNode.next=head;
            head=newNode;
        }
    }

    // insert at a position
    public void addPosition(int position, String data)
    {
        if(totalLLSize()<position || position<0)
            System.out.println("Invalid Position");
        else
        {
            LL.Node newNode = new LL().new Node(data);
            LL.Node temp = head;
            int count=0;
            while(temp.next != null)
            {
                if(count == position-2)
                    break;
                else{
                    temp=temp.next;
                    count++;
                }
            }
            LL.Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
        }
    }

    // insert at last
    public void addLast(String data)
    {
        LL.Node newNode = new LL().new Node(data);
        this.size++;

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
            this.size--;
            LL.Node temp = head;
            head = temp.next;
        }
    }

    // delete at a position
    public void deletePosition(int position)
    {
        if(totalLLSize()<position || position<0)
            System.out.println("Invalid Position");
        else
        {
            LL.Node temp = head;
            int count=0;
            while(temp.next != null)
            {
                if(count == position-2)
                    break;
                else{
                    temp=temp.next;
                    count++;
                }
            }
            LL.Node tempNode = temp.next;
            temp.next = tempNode.next;
            temp.next.next=null;
        }
    }

    // delete at last
    public void deleteLast()
    {
        if(head == null)
            System.out.println("The LinkedList is empty");
        else{
            this.size--;
            LL.Node temp = head;
            while(temp.next.next != null)
            {
                temp=temp.next;
            }
            temp.next=null;
        }
    }

    // printing all the nodes
    public void printNodes(LL.Node head)
    {
        LL.Node currNode = head;
        while(currNode!=null)
        {
            System.out.print(currNode.data+" ");
            currNode=currNode.next;
        }
    }

    // reverse a linkedlist
    public void reverseLinkedList()
    {
        LL.Node previous = null;
        LL.Node current = head;
        LL.Node next = null;
        while(current != null)
        {
            // save the next node
            next = current.next;
            // reverse current node's pointer
            current.next = previous;
            // move pointers one step forward
            previous = current;
            current = next;
        }
        head = previous;
    }

    // reverse linkedlist using recursion
    public LL.Node reverseLinkedListRecursion(LL.Node head)
    {
        if(head.next==null)
            return head;

        LL.Node newNode = reverseLinkedListRecursion(head.next);
        head.next.next=head;
        head.next=null;

        return newNode;
    }

    public LL.Node middleLinkedList(LL.Node head)
    {
        LL.Node slow = head;
        LL.Node fast = head;
        while(fast != null && fast.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    // returning the total number of linkedlist size
    public int totalLLSize()
    {
        return this.size;
    }

}
public class LinkedListInsertion {
    public static void main(String args[])
    {
        LinkedList obj = new LinkedList();
        obj.addFirst("a");
        obj.addFirst("is");
        obj.addLast("method");
        obj.addPosition(3,"Java");

        System.out.println("After Inserting All Nodes:");
        obj.printNodes(obj.getHead());
        System.out.println();

//        LL.Node newHead=obj.reverseLinkedListRecursion(obj.getHead());
//        System.out.println("After Reversing All Nodes:");
//        obj.printNodes(newHead);
//        System.out.println();

        LL.Node middleHead=obj.middleLinkedList(obj.getHead());
        System.out.print("Middle of All Nodes: "+middleHead.data);
//
//        obj.deletePosition(3);
//        obj.printNodes();
//        System.out.println();
//
//        int totalSize= obj.totalLLSize();
//        System.out.println("Total Linkedlist size is: "+totalSize);
//
//        obj.deleteFirst();
//        obj.deleteLast();
//
//        System.out.println("\nAfter Deleting First and Last Nodes:");
//        obj.printNodes();
//        System.out.println();
//
//        obj.totalLLSize();
//        int totalSize1= obj.totalLLSize();
//        System.out.println("Total Linkedlist size is: "+totalSize1);
    }
}
