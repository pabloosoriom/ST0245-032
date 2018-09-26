
/**
 * Write a description of class Solicitud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solicitud
{
    private String name;
    private int cantidad;
    public Solicitud(int cantidad,String name){
        this.cantidad=cantidad;
        this.name=name;
    }

    public int getCantidad(){
        return cantidad;
    }

    public String getName(){
        return name;
    }	

}
