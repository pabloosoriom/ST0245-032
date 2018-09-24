
/**
 * Clase de lista enlazada para su implementación en el código
 * 
 * @author Pablo Alberto Osorio Marulanda y Verónica Mendoza Iguarán 
 * @version 1
 */
import java.lang.IndexOutOfBoundsException;
import javafx.geometry.Point3D;
public class ListaPeligro
{
    private static Node first;
    private static int size;
    public ListaPeligro(){    
        size = 0;
        first = null;	
    }

    /**
     * Metodo para  añadir un nodo al inicio de la lista
     *
     * @param  punto  Dato respectivo a la localización de la abeja que se agregará
     */
    public static void añadirInicio(Point3D punto){
        Node n=new Node(punto);
        if(first==null){
            first=n;
        }else{
            Node temp=first;
            Node nuevo=new Node(n.data);
            nuevo.enlazarSiguiente(temp);
            first=nuevo;
        }

    }

    /**
     * Metodo para remover el nodo del inicio de la lista
    */
    public static void removeFirst(){
        if(first==null){
            System.out.println("Finalizado");
        }else if (first.next==null){
            first=null;            
        }else{
            first=first.next;
        }

    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private static Node getNode(int index) throws IndexOutOfBoundsException {
        size=size();
        if (index >= 0 ) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    // Retorna el tamaño actual de la lista
    /**
     * Metodo para retornar el tamaño de la lista
     *
     * @return  int Tamaño de la lista
     */public static int size()
    {
        Node temp=first;
        while(temp!=null){
            size++;
            temp= temp.next;
        }
        return size;
    }
    

    //Retorna dato de un nodo específico
    /**
     * Metodo para Obtener el índice del primer dato de la lista
     * @param  Int index Indice de la prmera posicion
     */
    public static Point3D get(int index) throws IndexOutOfBoundsException {
        Node temp = first;
        return temp.data;
    }

}

