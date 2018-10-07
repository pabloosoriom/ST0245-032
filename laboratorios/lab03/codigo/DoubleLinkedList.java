
/**
 * The DoubleLinkedList class is intended to 
 * simulate a dually linkedlist implemented in java.
 * This is solution to exersice 1_4 of laboratory 3
 * @author Pablo Alberto Osorio Marulanda, 
 * Verónica Mendoza Iguarán
 * @version 7/10/2018
 */

import java.lang.IndexOutOfBoundsException; 
import java.util.*;

public class DoubleLinkedList {
    private Node first;
    private int size;
    
    public DoubleLinkedList()
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
     *Returns the current size of the list
     */
    public int size()
    {
        Node temp=first;
        while(temp!=null){
            size++;
            temp= temp.next;
        }
        return size;
    }

    /**
     * Insert a data in the index position
     * @param data - data to enter the list
     * @param index - index of the element to return
     */
    public void insert(int data, int index)
    {
        Node nuevo=new Node(data);
        if(first==null){
            first=nuevo;
        }else if(index==0){
            nuevo.next=first;
            first=nuevo;
            nuevo.last=null;
            first.last=nuevo;
        }else if(index>0&&index<size){
            getNode(index-1).next=nuevo;
            nuevo.next=getNode(index);
            getNode(index).last=nuevo;
            nuevo.last=getNode(index-1);
        }else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    /**
     * Delete the data in the index position.
     * @param index - index of the element to delete
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index)
    {
        if(first==null){
            throw new IndexOutOfBoundsException();
        }else if(index==0){
            if(size()==1){
                first=null;
            }else{
                Node temp=getNode(index+1);
                getNode(index).next=null;
                first=temp;
                getNode(index).last=null;
            }
        }else if(index==size()-1){
            getNode(index-1).next=null;
        }else if(index>0&&index<size){
            Node temp=getNode(index+1);
            getNode(index-1).next=null;
            getNode(index-1).next=temp;
            temp.last=getNode(index-1);
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Check if a data is in the list
     * @param data - data that will be searched in the list
     * @return true if the data is in the list
     * @throws IndexOutOfBoundsException
     */
    public boolean contains(int data)
    {
        int posicion=0;
        Node nodoQueEstoyVisitando = first;
        while (nodoQueEstoyVisitando != null) {
            if (nodoQueEstoyVisitando.data == data){
                return true;
            }
            nodoQueEstoyVisitando = nodoQueEstoyVisitando.next;
            posicion++;
        }
        System.out.println("La posicion del nodo con el dato buscado es: "+posicion);
        return false;
    }
}
