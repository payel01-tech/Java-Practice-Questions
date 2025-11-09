package BinaryTree;

public class IdenticalBinaryTree {
    static int index=-1;
    public static Node buildBinaryTree(int preOrder[])
    {
        index++;
        if(index>=preOrder.length || preOrder[index]==-1)
            return null;
        Node root = new Node(preOrder[index]);
        root.left=buildBinaryTree(preOrder);
        root.right=buildBinaryTree(preOrder);
        return root;
    }
    public static void displayTree(Node root)
    {
        if(root==null)
        {
            System.out.print("null->");
            return;
        }
        displayTree(root.left);
        System.out.print(root.data+"->");
        displayTree(root.right);
    }

    public static boolean identicalTree(Node p,Node q)
    {
        if(p==null || q==null)
            return p==q;
        boolean isLeft=identicalTree(p.left,q.left);
        boolean isRight=identicalTree(p.right,q.right);
        return (isLeft && isRight && p.data==q.data);
    }
    public static void main(String args[])
    {
        int arr1[]=new int[]{1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        int arr2[]=new int[]{1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root1 =buildBinaryTree(arr1);
        index=-1;
        Node root2 =buildBinaryTree(arr2);
        displayTree(root1);
        System.out.println();
        displayTree(root2);
        boolean result= identicalTree(root1,root2);
        System.out.print(result ? "\nBoth the trees are identical" : "\nBoth the trees are not identical");
    }
}
