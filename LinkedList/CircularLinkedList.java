package LinkedList;


class CL{
    public class Node_Circular{
        String data;
        Node_Circular next;

        public Node_Circular(String data){
            this.data = data;
            this.next = null;
        }
    }
}

class CircularLinkedListImpl{
    private CL.Node_Circular head;
    private int size;

    public CircularLinkedListImpl()
    {
        this.size = 0;
    }

    public CL.Node_Circular getHead()
    {
        return head;
    }

    public void addFirst(String data)
    {
        CL.Node_Circular newNode = new CL().new Node_Circular(data);

        this.size++;

        if(head == null)
        {
            this.head = newNode;
            newNode.next = newNode;
        }
        else
        {
            newNode.next=head;
            CL.Node_Circular currNode = head;
            while(currNode.next != head)
            {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            head = newNode;
        }
    }

    public void addLast(String data){

        CL.Node_Circular newNode = new CL().new Node_Circular(data);

        this.size++;

        if(head == null)
        {
            this.head = newNode;
            newNode.next = newNode;
        }
        else{
            CL.Node_Circular currNode = head;
            while(currNode.next != head)
            {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.next = head;
        }
    }

    public void printNodes(CL.Node_Circular head)
    {
        CL.Node_Circular currentNode = head;

        while(currentNode.next != head)
        {
            System.out.print(currentNode.data+"->");
            currentNode = currentNode.next;
        }
        System.out.print(currentNode.data+"->back to "+head.data);
    }

    // using iteration

    public void reverseCircularLinkedList()
    {
        CL.Node_Circular previous = null;
        CL.Node_Circular currNode = head;
        CL.Node_Circular nextNode;

        do{
            nextNode = currNode.next;
            currNode.next = previous;

            previous = currNode;
            currNode = nextNode;
        }while(currNode != head);

        head.next = previous;
        head = previous;
    }

    // using recursive
    public CL.Node_Circular reverseRecursionCircularLinkedList(CL.Node_Circular head)
    {
        if (head == null && head.next == head)
            return head;

        if(head.next.next == head){
            CL.Node_Circular newNode = head.next;
            head.next.next=head;
            return newNode;
        }

        CL.Node_Circular newNode = reverseRecursionCircularLinkedList(head.next);

        head.next.next = head;
        head.next = newNode;

        return newNode;
    }
}
public class CircularLinkedList {
    public static void main(String args[])
    {
        CircularLinkedListImpl obj = new CircularLinkedListImpl();

//        obj.addFirst("language");
//        obj.addFirst("a");
//        obj.addFirst("is");
//        obj.addFirst("Java");
//
//        obj.printNodes(obj.getHead());

        obj.addLast("Java");
        obj.addLast("is");
        obj.addLast("a");
        obj.addLast("language");

        obj.printNodes(obj.getHead());

        CL.Node_Circular newHead = obj.reverseRecursionCircularLinkedList(obj.getHead());

        System.out.println();

        obj.printNodes(newHead);
    }
}

