/**
 * The node class is intended to 
 * simulate a node of DoubleLinkedList.
 * @author Pablo Alberto Osorio Marulanda, 
 * Verónica Mendoza Iguarán
 * @version 7/10/2018
 */

public class Node
{
    int data;
    Node next;
    Node last;
    
    /**
     * Constructor of Node class.
     * @param data - data of the node.
     */
    public Node(int data){
        next=null;
        last=null;
        this.data=data;
    }
}