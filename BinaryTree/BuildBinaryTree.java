package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    static int ans=0;
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
        ans=Math.max(ans,left_height+right_height);
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

    public static int diameterOfBinaryTree(Node root) {
//        if(root==null)
//            return 0;
//        int leftDiameter=diameterOfBinaryTree(root.left);
//        int rightDiameter=diameterOfBinaryTree(root.right);
//        int currentDiameter=height(root.left)+height(root.right);
//        int MaxDiameter=Math.max(leftDiameter,rightDiameter);
//        return Math.max(MaxDiameter,currentDiameter);
        height(root);
        return ans;
    }

    public static void kthLevelofTree(Node root,int k)
    {
        if(root==null)
            return;
        if(k==1)
        {
            System.out.print(root.data+" ");
            return;
        }
        kthLevelofTree(root.left,k-1);
        kthLevelofTree(root.right,k-1);
    }

    public static int sumTree(Node root)
    {
        if(root==null)
            return 0;
        int leftSumTree=sumTree(root.left);
        int rightSumTree=sumTree(root.right);
        root.data+=leftSumTree+rightSumTree;
        return root.data;
    }

    public static void binaryTreePaths(Node root,String path,List<String> ans) {
        if(root.left==null && root.right==null){
            ans.add(path);
            return;
        }
        if(root.left !=null)
            binaryTreePaths(root.left,path+"->"+String.valueOf(root.left.data),ans);
        if(root.right !=null)
            binaryTreePaths(root.right,path+"->"+String.valueOf(root.right.data),ans);
    }

    public static List<String> binaryTreePaths(Node root) {
        String path=String.valueOf(root.data);
        List<String> ans=new ArrayList<>();
        binaryTreePaths(root,path,ans);
        return ans;
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
        int DiameterTree=diameterOfBinaryTree(root);
        System.out.println("Diameter of the Binary Tree through Recursion is: "+DiameterTree);
        int level = 3;
        System.out.println(level+"th level of tree");
        kthLevelofTree(root,level);
        int sumTreeValue= sumTree(root);
        System.out.println("\nTotal Sum of the Tree is: "+sumTreeValue);
        System.out.println("PreOrder Traversal: ");
        PreOrder_Traversal(root);
        System.out.println("\nBinary Tree Paths are");
        List<String> ans=binaryTreePaths(root);
        for(String val:ans)
            System.out.println(val);
    }
}
