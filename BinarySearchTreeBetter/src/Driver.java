

public class Driver {
    public static void main(String[] args) throws Exception {
        BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
        //System.out.println(b.root.data);
        b.insert(1);
        b.insert(5);
        b.insert(6);
        b.insert(4);
        b.insert(7);
        b.insert(10);
        b.insert(11);
        b.insert(3);

        b.printInorder(b.root);
        b.delete(5);
        b.printInorder(b.root);
        System.out.println();
        System.out.println("height: " + b.height());

        System.out.println("found: " + b.search(5).data);

    }
}
