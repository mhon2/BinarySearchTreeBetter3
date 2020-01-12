/*T data;
private TreeNode left;
private TreeNode right;
TreeNode(); //default constructor should set global variables to NULL
TreeNode(T t); //constructor that initializes data to t
TreeNode getLeft();
TreeNode getRight();
*/

public class TreeNode <Type> extends Node{
    Type data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode()
    {
        data = null;
        left = null;
        right = null;
    }

    public TreeNode(Type t)
    {
        data = t;
        left = null;
        right = null;
    }

    public Type data()
    {
        return data;
    }

    public TreeNode<Type> getLeft()
    {
        return left;
    }

    public void setLeft(TreeNode<Type> t) { left = t;}

    public TreeNode<Type> getRight()
    {
        return right;
    }

    public void setRight(TreeNode<Type> t) { right = t;}
}
