/**REMEMBER: Since you are creating a generic BST rather than assuming specific data, you must properly implement the Comparable interface.
 TreeNode<Type> root;
 BinarySearchTree<Type>(); //default constructor should set root to NULL
 int height();
 void printInorder(); \\This should be inherited from BinaryTree
 void printPreorder(); \\This should be inherited from BinaryTree
 void printPostorder(); \\This should be inherited from BinaryTree
 void printBreadthFirst(); \\Both should be inherited from BinaryTree
 void insert(Type t); //there should be no duplicate data in the tree
 Node search(Type t);
 void delete(Type t);
 static BinarySearchTree<Type> convert(BinaryTree<Type> bt);
 static BinarySearchTree<Type> convert(LinkedList<Type> ll); //precondition: ll must be sorted
 or static BinarySearchTree<Type> convert(Type[] arr); //precondition arr must be sorted
 Standby on instructions for this one as Type[] may cause you issues
 */
import java.lang.NullPointerException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<Type extends Comparable<Type>> extends BinaryTree {
    boolean isFound = false;


    public BinarySearchTree()
    {
        super();
    }

    public BinarySearchTree(TreeNode<Type> root) {super(root);}

    public int height()
    {
        return super.height();
    }

    public TreeNode<Type> search(Type t) throws Exception
    {
        TreeNode<Type> current = root;
        try
        {
            while(!isFound)
            {
                isFound = true;
                if(current == null){
                    root = new TreeNode<Type>(t);
                    System.out.println();
                }


                if ((t.compareTo((Type) current.data) < 0))//left   && (!isFound)
                {
                    //System.out.println("went left");
                    BinarySearchTree<Type> bst = new BinarySearchTree<Type>(current.getLeft());
                    return bst.search(t);
                }
                if ((t.compareTo((Type) current.data) > 0))//right     && (!isFound)
                {
                    //System.out.println("went right");
                    BinarySearchTree<Type> bst = new BinarySearchTree<Type>(current.getRight());
                    return bst.search(t);//(Type)bst.root.getLeft().datat

                }

                else if((t.compareTo((Type) root.data) == 0)) //found key isFound
                {
                    System.out.println("found it!");
                    isFound = true;
                    break;
                }

            }
            return current;
        }
        catch(NullPointerException e)
        {
            System.err.println("That value wasn't found dude!!");
        }
        return new TreeNode<Type>(null);
    }

    public void insert(Type t)
    {
        if(t == null) { return;}

        if(root == null) { root = new TreeNode<Type>(t);
        System.out.println("made root");}

        else if(t.compareTo((Type)root.data) < 0)//left
        {
            if(root.getLeft() == null)
                root.setLeft(new TreeNode<Type>(t));
            else
            {
                BinarySearchTree<Type> bst = new BinarySearchTree<Type>(root.getLeft());//new TreeNode<Type>(t)
                bst.insert(t);
            }

        }
        else//right
        {
            if(root.getRight() == null)
                root.setRight(new TreeNode<Type>(t));
            else
            {
                BinarySearchTree bst = new BinarySearchTree<Type>(root.getRight());//new TreeNode<Type>(t)
                bst.insert(t);
            }
        }

    }

    public void delete(Type t) throws Exception
    {
        /*//Type[] arr = new Type[]();
        ArrayList<Type> list = new ArrayList<>();

         list = putInorder(root);
        if(root == null)
        {
            return;
        }
        else if((search(t).getLeft() == null) &&(search(t).getRight() == null))//no children
        {
            System.out.println("nochildren");
            if(root == search(t))
                root.data = null;
            else
            {
                for(int i = 0; i < list.size()-1; i++)
                {
                    if(list.get(i+1).equals(t)) {
                        list.set(i,list.get(i+1));
                        list.set(i+1,null);
                    }

                }

            }
        }
        else if((search(t).getLeft() != null) &&(search(t).getRight() != null))//2 children
        {

        }
        else//1 child
        {

        }*/
        root = deleteTN(root, t);
    }

    public TreeNode<Type> deleteTN(TreeNode<Type> root, Type t) {
        TreeNode<Type> current = root;
        if(root == null){
            return root;
        }
        if((root.data.compareTo((Type) current.data) < 0)){
            root.setLeft(deleteTN(root.getLeft(), t));
        }else if(root.data.compareTo((Type) current.data) > 0){
            root.setRight(deleteTN(root.getRight(), t));
        }else{
            if(root.getLeft() == null && root.getRight() == null){
                root = null;
            }else if(root.getRight() == null){
                root = root.getLeft();
            }else if(root.getLeft() == null){
                root = root.getRight();
            }else{
                TreeNode<Type> temp  = findMinFromRight(root.getRight());
                root.data = (Type)temp.data;
                root.setRight(deleteTN(root.getRight(), (Type)temp.data));
                
            }
        }
        return root;
    }

    protected TreeNode findMinFromRight(TreeNode r) {
        while(r.getLeft() != null){
            r = r.getLeft();
        }
        return r;
    }

    public void printInorder(TreeNode<Type> r)
    {
        ArrayList<Type> arr = new ArrayList<Type>();

        if(r == null)
            return;

            printInorder(r.getLeft());
            System.out.print(r.data + " ");
            printInorder(r.getRight());

    }

    public ArrayList<Type> putInorder(TreeNode<Type> r)
    {
        ArrayList<Type> arr = new ArrayList<Type>();

        while(r.getLeft()!=null && r.getRight()!=null) {
            printInorder(r.getLeft());
            System.out.print(r.data + " ");
            arr.add(r.data);
            printInorder(r.getRight());
        }
        return arr;
    }
}
