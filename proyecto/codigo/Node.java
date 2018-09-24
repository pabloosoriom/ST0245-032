
/**
 * Write a description of class Nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javafx.geometry.Point3D;
public class Node
{
    Point3D data;
    Node next;
    public Node(Point3D data){
        this.next=null;
        this.data=data;

    }

    public void enlazarSiguiente(Node n){
        next=n;
    }

}


