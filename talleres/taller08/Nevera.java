
/**
 * Write a description of class Nevera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nevera
{
    private int codigo;
    private String descripcion;

    public Nevera(int codigo, String descripcion){
        this.codigo=codigo;
        this.descripcion=descripcion;
    }
    
    public int getCodigo(){
        return codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }	
}
