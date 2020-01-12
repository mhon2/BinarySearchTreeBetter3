

/*TreeNode root;
BinaryTree(); //default constructor should set root to NULL
BinaryTree(TreeNode r); // constructor that sets root to r
int height();
void printGivenLevel(int level);
void printBreadthFirstQ();
void insert(T data);
//you may implement helper methods for the following, but you do not need them
void printInorder();
void printPreorder();
void printPostorder();
void printBreadthFirst();
*/
public class BinaryTree <Type>{
    TreeNode root;
    int height;

    public BinaryTree()
    {
        root = null;
        height = 0;
    }

    public BinaryTree(TreeNode r)
    {
        root = r;
        height = 1;
    }

    public void printGivenLevel(int level)
    {
        BinaryTree temp = new BinaryTree(root);
        for(int i = 0; i < level; i++)
        {
            if(temp == null)
                System.out.println("null");
            if(level == 1)
                System.out.println(temp.root.data);
            else//AKA if (level > 1)
            {
                BinaryTree<Type> left = new BinaryTree<Type>(root.getLeft());
                left.printGivenLevel(level-1);
                BinaryTree<Type> right = new BinaryTree<Type>(root.getRight());
                right.printGivenLevel(level-1);
                //System.out.println(temp.root.getLeft().data);//CHECK LEFT
                System.out.println(temp.root.getRight().data);//CHECK RIGHT
            }
        }
    }

    public void printBreadthFirstQ()
    {
        BinaryTreeQueue<TreeNode> q = new BinaryTreeQueue<TreeNode>();
        TreeNode<Type> temp = root;
        while(temp != null)
        {
            System.out.println(temp);
            q.enqueue(temp.getLeft());
            q.enqueue(temp.getRight());

            temp = q.dequeue();
        }
    }

    public void insert(Type data)
    {
        TreeNode temp = root;
        while(temp != null)
        {
            temp = temp.getLeft();
        }
        temp.setLeft(new TreeNode<Type>((Type) root.data));//make setleft method
    }

    public int height()
    {
        int height;

        if (root == null)
            return 0;

        if (root.getLeft() == null && root.getRight() == null)
            return 1;

        if (root.getRight() == null)
            height = new BinaryTree<Type>(root.getLeft()).height() + 1;
        else if (root.getLeft() == null)
            height = new BinaryTree<Type>(root.getRight()).height() + 1;
        else
            height = Math.max(new BinaryTree<Type>(root.getLeft()).height(), new BinaryTree<Type>(root.getRight()).height()) + 1;
        return height;
    }

    public void printInorder()//check left; root; check right
    {

    }

    public void printPreorder()//root; check left; check right
    {

    }

    public void printBreadthFirst()
    {

    }
}
