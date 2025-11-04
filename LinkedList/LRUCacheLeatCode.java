package LinkedList;

//We can only enter the no. of nodes that are equal to the capacity of the LRU Cache
//To implement this LRU Cache we need to use two data structure, one is the linkedlist and another one is the map to store the key and the node corresponding to that key
//whenever you will do put operation it means adding the node in first place as it will be the most recently used node and also storing the key and node in the map
//
//To add/put any nodes we need to consider some conditions
//1. If we want to put (1,3) and there's a node already (1,1) in the map, then there's a match in the key that is 1,
//then we need to delete that node from the linkedlist and from the map first and then we need to add the new node at first and also in the map
//2. If the map size is equal to the capacity of the LRU Cache then we need to delete the last node and then need to add the new node at first and also in the map
//
//To get any nodes we need to consider some conditions
//1. If the map is empty or the key doesn't exist then we need to return -1
//2. Whenever we are trying to get any nodes, we need to first store the value of that node to return it
//3. Then we need to delete that node from the linkedlist and map and then we need to add that node in the linkedlist at first position and map

import java.util.HashMap;

public class LRUCacheLeatCode {
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

        private DoubleLinkedList head= new DoubleLinkedList(-1,-1);
        private DoubleLinkedList tail= new DoubleLinkedList(-1,-1);
        private int capacity;
        HashMap<Integer,DoubleLinkedList> map = new HashMap<>();

        public LRUCacheLeatCode(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.previous = head;
        }

        public void addFirstDoubleNode(DoubleLinkedList newNode)
        {
            DoubleLinkedList tempNext=head.next;
            newNode.previous=head;
            newNode.next=tempNext;
            head.next=newNode;
            tempNext.previous=newNode;
        }

        public void deleteDoubleNode(DoubleLinkedList oldNode)
        {
            DoubleLinkedList tempPrevious=oldNode.previous;
            DoubleLinkedList tempNext=oldNode.next;
            tempPrevious.next=tempNext;
            tempNext.previous=tempPrevious;
        }

        public int get(int key) {
            if(map.isEmpty() || !map.containsKey(key))
                return -1;
            int val=map.get(key).value;
            DoubleLinkedList currentNode = map.get(key);
            deleteDoubleNode(currentNode);
            map.remove(key);
            addFirstDoubleNode(currentNode);
            map.put(key,currentNode);
            return val;
        }

        public void put(int key, int value) {
            if(map.containsKey(key))
            {
                deleteDoubleNode(map.get(key));
                map.remove(key);
            }

            if(map.size()==capacity)
            {
                map.remove(tail.previous.key);
                deleteDoubleNode(tail.previous);
            }

            DoubleLinkedList newNode = new DoubleLinkedList(key,value);
            addFirstDoubleNode(newNode);
            map.put(key,newNode);
        }

        public static void main(String args[])
        {
            LRUCacheLeatCode cache = new LRUCacheLeatCode(2);
            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1)); // 1
            cache.put(3, 3); // evicts key 2
            System.out.println(cache.get(2)); // -1
            cache.put(4, 4); // evicts key 1
            System.out.println(cache.get(1)); // -1
            System.out.println(cache.get(3)); // 3
            System.out.println(cache.get(4)); // 4
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
