
/**
 * Clase con los datos de una nevera.
 * 
 * @author Pablo Alberto Osorio Marulanda, 
 * Verónica Mendoza Iguarán 
 * @version 7/10/2018
 */
public class Nevera
{
    private int codigo;
    private String descripcion;

    /**
     * Constructor que recibe la información de la nevera
     * 
     * @param codigo - codigo que identifica la nevera
     * @param descripcion - descripcion o marca de la nevera
     */
    public Nevera(int codigo, String descripcion){
        this.codigo=codigo;
        this.descripcion=descripcion;
    }
    
    /**
     * Método para obtener el código de la nevera
     * 
     * @return el codigo de la nevera
     */
    public int getCodigo(){
        return codigo;
    }
    
    /**
     * Método para obtener la descripción de la nevera
     * 
     * @return la descripción de la nevera
     */
    public String getDescripcion(){
        return descripcion;
    }	
}