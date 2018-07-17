
/**
 * Punto 2 del taller 1 de Estructura de datos y algoritmos.
 * 
 * @author (Pablo Alberto Osorio y Verónica Mendoza Iguarán) 
 * @version (17/07/2018)
 */
public class Fecha {
    private final byte dia;
    private final byte mes;
    private final short anio;

    /**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     */
    public Fecha(byte dia, byte mes, short anio) {
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

    /**
     * Método para obtener la variable global dia.
     *
     * @return el dia
     */
    public byte dia() {
        return this.dia;
    }

    /**
     * Método para obtener la variable global mes.
     *
     * @return el mes
     */
    public byte mes() {
        return this.mes;
    }

    /**
     * Método para obtener la variable global anio.
     *
     * @return el año
     */
    public short anio() {
        return this.anio;
    }

    /**
     * @param otra representa la fecha con la culase va a comparar.
     *
     * El método comprar se encarga de devolvernos respuesta a tres posibilidades.
     * 1: si la fecha es menor que la otra retorna -1.
     * 2: si la fecha es igual que la otra retorna 0.
     * 3: si la fecha es mayor que la otra retorna 1.
     *
     * @return -1 sí es menor; 0 sí es igual; 1 sí es mayor.
     *
     */

    public int comparar(Fecha otra) {
        if(anio<otra.anio()){
            return -1;
        }else if(anio==otra.anio()){
            if(mes<otra.mes()){
                return -1;
            }else if(mes>otra.mes()){
                return 1;
            }else if(dia<otra.dia()){
                return -1;
            }else if(dia>otra.dia()){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 1;
        }
    }

    /**
     * toString se encargará de convertir el tipo abstracto fecha en un tipo cadena
     * para su posterior visualización
     *
     * @return una cadena que contiene la fecha
     */
    public String toString() {
        return dia() +"/"+ mes() + "/" + anio();
    }
}