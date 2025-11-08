package BinaryTree;

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
    }
}
