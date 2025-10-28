package LinkedList;

import java.util.HashMap;

class LRU{

    class DoubleLinkedList{

        DoubleLinkedList previous;
        int key,value;
        DoubleLinkedList next;

        public DoubleLinkedList(int key,int val)
        {
            this.key = key;
            this.value = val;
            previous=null;
            next=null;
        }
    }
}

class LRUCacheImpl{
    private LRU.DoubleLinkedList head= new LRU().new DoubleLinkedList(-1,-1);
    private LRU.DoubleLinkedList tail= new LRU().new DoubleLinkedList(-1,-1);
    private int capacity;
    HashMap<Integer,LRU.DoubleLinkedList> map = new HashMap<>();

    public LRUCacheImpl(int capacity) {
        this.capacity=capacity;
    }

    public void addFirstDoubleNode(LRU.DoubleLinkedList newNode)
    {
        LRU.DoubleLinkedList tempNext=head.next;
        newNode.previous=head;
        newNode.next=head.next;
        head.next=newNode;
        tempNext.previous=newNode;
    }

    public void deleteDoubleNode(LRU.DoubleLinkedList oldNode)
    {
        LRU.DoubleLinkedList tempPrevious=oldNode.previous;
        LRU.DoubleLinkedList tempNext=oldNode.next;
        head.next=tempNext;
        tempNext.previous=tempPrevious;
    }

    public int get(int key) {

    }

    public void put(int key, int value) {
        // if map reaches to the capacity of the LRU Cache then we have to remove the least recently used node
        if(map.size()==capacity)
        {
            map.remove(tail.previous.key);
            deleteDoubleNode(tail.previous);
        }

        // if linkedlist contains duplicate key like (1,1) and want to insert (1,3)
        // then we need to remove the old element from the linkedlist and map and insert the new element
        if(map.containsKey(key))
        {
            deleteDoubleNode(map.get(key));
            map.remove(key);
        }
        LRU.DoubleLinkedList newNode = new LRU().new DoubleLinkedList(key,value);
        addFirstDoubleNode(newNode);
        map.put(key,newNode);
    }

}

public class LRUCache {
    public static void main(String args[])
    {

    }
}
