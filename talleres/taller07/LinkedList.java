
import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
import java.util.*;
public class LinkedList {
    private Node first;
    private int size;
    public LinkedList()
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

    // Retorna el tamaño actual de la lista
    public int size()
    {
        Node temp=first;
        while(temp!=null){
            size++;
            temp= temp.next;
        }
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index)
    {
        Node nuevo=new Node(data);
        if(first==null){
            first=nuevo;
        }else if(index==0){
            nuevo.next=first;
            first=nuevo;
        }else if(index>0&&index<size){
            getNode(index-1).next=nuevo;
            nuevo.next=getNode(index);
        }else {
            throw new IndexOutOfBoundsException();
        }
    }
    // Borra el dato en la posición index
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
            }
        }else if(index==size()-1){
            getNode(index-1).next=null;
        }else if(index>0&&index<size){
            Node temp=getNode(index+1);
            getNode(index-1).next=null;
            getNode(index-1).next=temp;
        }else {
            throw new IndexOutOfBoundsException();
        }

    }

    // Verifica si está un dato en la lista
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
