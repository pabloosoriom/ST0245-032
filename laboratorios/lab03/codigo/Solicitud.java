
/**
 * Clase con la información de cada solicitud 
 * hecha a un almacen de neveras.
 * 
 * @author Pablo Alberto Osorio Marulanda, 
 * Verónica Mendoza Iguarán 
 * @version 7/10/2018
 */
public class Solicitud
{
    private String name;
    private int cantidad;
    
    /**
     * Constructor que recibe la información de la solicitud
     * 
     * @param cantidad - cantidad de neveras que se solicitan
     * @param name - nombre de quien solicita neveras
     */
    public Solicitud(int cantidad,String name){
        this.cantidad=cantidad;
        this.name=name;
    }

    /**
     * Método para obtener la cantidad de neveras solicitadas
     * 
     * @return la cantidad de neveras solicitadas
     */
    public int getCantidad(){
        return cantidad;
    }

    /**
     * Método para obtener el nombre de quien solicita neveras
     * 
     * @return el nombre de quien solicita neveras
     */
    public String getName(){
        return name;
    }	

}