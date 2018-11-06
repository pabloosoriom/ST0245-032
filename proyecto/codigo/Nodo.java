
/**
 * Write a description of class Nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.LinkedList;
import javafx.geometry.Point3D;
public class Nodo
{
    LinkedList <Point3D> abejas;
    Point3D max;
    Point3D min;
    Nodo[] hijos;
    public Nodo(Point3D max,Point3D min){
        this.max=max;
        this.min=min;           
        hijos=new Nodo[8];
        abejas= new LinkedList<>();
    }

    
}
