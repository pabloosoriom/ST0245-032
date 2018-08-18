
/**
 * Solución al ejercicio 1.1 del laboratorio 1.
 * 
 * @author (Pablo Alberto Osorio Marulanda - Verónica Mendoza Iguarán) 
 * @version (11/08/2018)
 */

public class Fibonacci
{
    /**
     * Método que recibe un parámetro 'n' y retorna el enésimo término de la serie de
     * Fibonacci utilizando recursión 
     */
    public static int fibonacci(int n){
        if(n==0 || n==1)return n; //condición de parada
        return fibonacci(n-1)+fibonacci(n-2); //llamado recursivo
    }
}
