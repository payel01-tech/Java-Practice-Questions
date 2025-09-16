package LinkedList;

class DL{
    public class Node_Double{
        Node_Double previous;
        String data;
        Node_Double next;

        public Node_Double(String data){
            this.previous = null;
            this.data = data;
            this.next = null;
        }
    }
}

class DoubleLinkedListImpl{
    private DL.Node_Double head;
    private DL.Node_Double tail;
    private int size;

    public DoubleLinkedListImpl()
    {
        this.size = 0;
    }

    public DL.Node_Double getHead()
    {
        return head;
    }

    public void addFirst(String data)
    {
        DL.Node_Double newNode = new DL().new Node_Double(data);

        this.size++;

        if(head == null)
        {
            this.head = newNode;
        }
        else{
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void addLast(String data){

        DL.Node_Double newNode = new DL().new Node_Double(data);

        this.size++;

        if(head == null)
        {
            this.head = this.tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void printNodes(DL.Node_Double head)
    {
        DL.Node_Double currentNode = head;
        while(currentNode != null)
        {
            System.out.print(currentNode.data+"->");
            currentNode = currentNode.next;
        }
        System.out.print("NULL");
    }

    // using iteration
    public void reverseNodes()
    {
        DL.Node_Double temp=null;
        DL.Node_Double currNode = head;
        while(currNode != null)
        {
            // swap next and previous
            temp = currNode.previous;
            currNode.previous = currNode.next;
            currNode.next = temp;

            // move to next node (which was previous before swap)
            currNode = currNode.previous;
        }

            // temp now points to the previous of the last processed node
            if (temp != null)
                head = temp.previous;
    }
}
public class DoubleLinkedList {
    public static void main(String args[])
    {
        DoubleLinkedListImpl obj = new DoubleLinkedListImpl();

//        obj.addFirst("language");
//        obj.addFirst("a");
//        obj.addFirst("is");
//        obj.addFirst("Java");
//        obj.printNodes(obj.getHead());

        obj.addLast("Java");
        obj.addLast("is");
        obj.addLast("a");
        obj.addLast("language");

        obj.printNodes(obj.getHead());

        System.out.println();

        obj.reverseNodes();

        obj.printNodes(obj.getHead());
    }
}
