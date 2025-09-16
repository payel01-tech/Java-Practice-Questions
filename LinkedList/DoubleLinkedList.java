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
            this.head = newNode;
        }
        else{
            DL.Node_Double currNode = head;
            while(currNode.next != null)
            {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.previous = currNode;
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
}
public class DoubleLinkedList {
    public static void main(String args[])
    {
        DoubleLinkedListImpl obj = new DoubleLinkedListImpl();

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
    }
}
