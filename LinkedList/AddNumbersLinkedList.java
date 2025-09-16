//You are given two non-empty linked lists representing two non-negative integers.
//The digits are stored in reverse order,
//and each of their nodes contains a single digit.
//Add the two numbers and return the sum as a linked list.

package LinkedList;

class LLNew{
    public class NewNode{
        int data;
        NewNode next;

        public NewNode()
        {
        }

        public NewNode(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
}

class LinkedListNew{
    private LLNew.NewNode head;
    private int size;

    public LinkedListNew()
    {
        this.size=0;
    }

    // insert at last
    public void addLast(int data)
    {
        LLNew.NewNode newNode = new LLNew().new NewNode(data);
        this.size++;

        if (head == null)
            this.head=newNode;
        else
        {
            LLNew.NewNode currNode = head;
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
        LLNew.NewNode currNode = head;
        while(currNode!=null)
        {
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }
        System.out.println("NULL");
    }

    // returning the total number of linkedlist size
    public int totalLLSize()
    {
        return this.size;
    }

    public static LinkedListNew addLinkedList(LinkedListNew LL1, LinkedListNew LL2)
    {
        LLNew.NewNode p = LL1.head;
        LLNew.NewNode q = LL2.head;
        LinkedListNew result = new LinkedListNew();
        int reminder=0,division=0;

        while(p !=null || q!= null)
        {
           int x = (p==null)?0:p.data;
           int y = (q==null)?0:q.data;

           int val =  x+y+division;
           reminder = val % 10;
           division = val / 10;
           result.addLast(reminder);

           if(p!=null)
               p=p.next;
           if(q!=null)
               q=q.next;
        }
        if(division>0)
         result.addLast(division);
        return result;
    }
}

public class AddNumbersLinkedList {

    public static void main(String args[])
    {
        LinkedListNew firstList = new LinkedListNew();
        firstList.addLast(8);
        firstList.addLast(0);
        firstList.addLast(0);
        firstList.addLast(1);

        firstList.printNodes();

        LinkedListNew secondList = new LinkedListNew();
        secondList.addLast(1);
        secondList.addLast(9);

        secondList.printNodes();

        LinkedListNew result= LinkedListNew.addLinkedList(firstList,secondList);
        result.printNodes();
    }
}
