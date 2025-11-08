package BinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        data=val;
        left=null;
        right=null;
    }
}

public class BuildBinaryTree {
    static int index=-1;
    public static Node buildBinaryTree(int[] preOrder)
    {
        index++;
        if(index>=preOrder.length || preOrder[index]==-1)
            return null;
        Node root=new Node(preOrder[index]);
        root.left=buildBinaryTree(preOrder);
        root.right=buildBinaryTree(preOrder);
        return root;
    }

    public static void PreOrder_Traversal(Node root)
    {
        if(root==null){
            System.out.print("null->");
            return;
        }
        System.out.print(root.data+"->");
        PreOrder_Traversal(root.left);
        PreOrder_Traversal(root.right);
    }

    public static void InOrder_Traversal(Node root)
    {
        if(root==null){
            System.out.print("null->");
            return;
        }
        InOrder_Traversal(root.left);
        System.out.print(root.data+"->");
        InOrder_Traversal(root.right);
    }

    public static void PostOrder_Traversal(Node root)
    {
        if(root==null){
            System.out.print("null->");
            return;
        }
        PostOrder_Traversal(root.left);
        PostOrder_Traversal(root.right);
        System.out.print(root.data+"->");
    }

    public static int levelOrder_Traversal(Node root)
    {
        if (root == null)
            return 0;

        Queue<Node> obj = new LinkedList<>();
        int height=1;
        obj.add(root);
        obj.add(null);
        while(obj.size()>0)
        {
            Node currentNode = obj.poll();
            if(currentNode==null)
            {
                if(obj.size()>0)
                {
                    height++;
                    System.out.print("\n");
                    obj.add(null);
                    // we are continuing here because there is no data for this null value and
                    // it might throw exception
                    continue;
                }
                else
                    break;
            }
            System.out.print(currentNode.data+" ");
            if(currentNode.left!=null)
                obj.add(currentNode.left);
            if(currentNode.right!=null)
                obj.add(currentNode.right);
        }
        return height;
    }

    public static int height(Node root)
    {
        if(root==null)
            return 0;
        int left_height=height(root.left); //will return 1 to the main root
        int right_height=height(root.right); //will return 2 to the main root
        return Math.max(left_height,right_height)+1; //will return 3 from the main root to the calling point
    }

    public static int count(Node root)
    {
        if(root==null)
            return 0;
        int left_count=count(root.left); //will return 1 to the main root
        int right_count=count(root.right); //will return 3 to the main root
        return (left_count+right_count+1); //will return 5 from the main root to the calling point
    }

    public static int sum(Node root)
    {
        if(root==null)
            return 0;
        int left_sum=sum(root.left); //will return the sum of the left subtree to the main root
        int right_sum=sum(root.right); //will return the sum of the right subtree to the main root
        return (left_sum+right_sum+root.data); //will return the sum of the left+right subtree+the root data from the main root to the calling point
    }

    public static void main(String args[])
    {
        int arr[]=new int[]{1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root=buildBinaryTree(arr);
        System.out.println("PreOrder Traversal: ");
        PreOrder_Traversal(root);
        System.out.println("\nInOrder Traversal: ");
        InOrder_Traversal(root);
        System.out.println("\nPostOrder Traversal: ");
        PostOrder_Traversal(root);
        System.out.println("\nLevelOrder Traversal: ");
        int height=levelOrder_Traversal(root);
        System.out.println("\nHeight of the Binary Tree: "+height);
        int heightTree=height(root);
        System.out.println("Height of the Binary Tree through Recursion is: "+heightTree);
        int countTree=count(root);
        System.out.println("Total no. of nodes of the Binary Tree through Recursion is: "+countTree);
        int sumTree=sum(root);
        System.out.println("Total sum of nodes of the Binary Tree through Recursion is: "+sumTree);
    }
}
