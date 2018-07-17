
/**
 * Punto 2 del taller 1 de Estructura de datos y algoritmos.
 * 
 * @author (Pablo Alberto Osorio y Verónica Mendoza Iguarán) 
 * @version (17/07/2018)
 */

public class Contador {
    private String id;
    private int cuenta;
    
    /**
     * Se inicializa la variable global en el constructor.
     */
    public Contador(String id) {
        this.id=id;
    }
    
    /**
     * Método para obtener el id del contador.
     *
     * @return el id
     */
    public String id(){
        return this.id;
    }
    
    /**
     * Método para obtener la suma del contador.
     *
     * @return el cuenta
     */
    public int cuenta(){
        return this.cuenta;
    }
    
    /**
     * Método para incrementar el contador en uno.
     *
     */
    public void incrementar() {
        cuenta++;
    }

    /**
     * Método para obtener el numero de incrementos desde su creacion.
     *
     * @return la cuenta
     */
    public int incrementos() {
        return this.cuenta;
    }

    /**
     * Método para representar el contador en cadena de caracteres.
     *
     */
    public String toString() {
        return "Identificación: "+(id())+"\t"+"Cuenta: "+(cuenta());
    }
}
