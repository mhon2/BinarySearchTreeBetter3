public class Node<Type> {
    /*T data;
    Node next;
    Node(); //default constructor should set global variables to NULL
    Node(T t); //constructor that initializes data to t*/

    Type data;
    Node next;

    public Node()//default constructor should set global variables to NULL
    {
        data = null;
        next = null;
    }

    public Node (Type t)
    {
        data = t;
        next = null;
    }


}
