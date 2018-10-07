
/**
 * Clase que simula una fila de personas de un banco.
 * 
 * @author Pablo Alberto Osorio Marulanda, 
 * Verónica Mendoza Iguarán 
 * @version 7/10/2018
 */

import java.util.*;
import java.util.Scanner; 
public class Fila
{
    static Queue<String> personas = new LinkedList();
    /**
     * Constructor para recibir una fila de personas
     * @param personas - fila con nombres de personas 
     */
    public Fila(Queue personas)
    {
        this.personas = personas;
    }
    
    /**
     * Método para obtener el tamaño de la fila
     * @return el tamaño de la fila, esto es, el numero de personas en ella
     */
    public int size(){
        return personas.size();
    }
    
    /**
     * Método para obtener el nombre de la persona en la fila
     * @return el nombre de cada persona en la fila
     */
    public String getNombre(){
        return personas.poll();
    }
    
    /**
     * Método para obtener toda una fila
     * @return toda una fila de personas
     */
    public Queue getFila(){
        return personas;
    }
}
