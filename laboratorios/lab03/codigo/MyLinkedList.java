/**
 * La clase MyLinkedList tiene la intención de
 * simular una LinkedList simplemente enlazada
 * implementada en java.
 * @author Pablo Alberto Osorio Marulanda, 
 * Verónica Mendoza Iguarán
 * @version 7/10/2018
 */

import java.lang.IndexOutOfBoundsException; 
import java.util.*;
public class MyLinkedList {
    private Node first;
    private int size;

    /**
     * Constructor of MyLinkedList class.
     */
    public MyLinkedList()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    /**
     * Insert a non-repeated data at the end of the list
     * @param data - data to enter the list.
     * @throws IndexOutOfBoundsException
     */
    public void SmartInsert(int data)
    {
        Node nuevo=new Node(data);
        Node temp = first;
        boolean noEsIgual = true;
        if(first==null){
            first=nuevo;
            size++;
        }else if(first!=null){
            if(first.next!=null){
                while(temp.next!=null){
                    if(temp.data==data){
                        noEsIgual= false;
                        break;
                    }
                    temp = temp.next;
                }
                if(noEsIgual){
                    temp.next=nuevo;
                    size++;
                }
            }
            else{
                if(first.data!=data){
                    first.next = nuevo;
                    size++;
                }
            }
        }else {
            throw new IndexOutOfBoundsException();
        }
    }
}